package xyz.rodit.snapmod.features.chatmenu

import de.robv.android.xposed.XposedBridge
import xyz.rodit.snapmod.CustomResources.string.menu_option_anti_auto_save
import xyz.rodit.snapmod.CustomResources.string.menu_option_auto_download
import xyz.rodit.snapmod.CustomResources.string.menu_option_auto_save
import xyz.rodit.snapmod.CustomResources.string.menu_option_stealth_mode
import xyz.rodit.snapmod.Shared
import xyz.rodit.snapmod.features.Feature
import xyz.rodit.snapmod.features.FeatureContext
import xyz.rodit.snapmod.mappings.FeedInfoHolder
import xyz.rodit.snapmod.mappings.FriendChatActionHandler
import xyz.rodit.snapmod.mappings.FriendChatActionMenuBuilder
import xyz.rodit.snapmod.mappings.SendChatAction
import xyz.rodit.snapmod.util.after
import xyz.rodit.snapmod.util.before

const val EVENT_PREFIX = "CUSTOM_ACTION"
const val EVENT_DELIMITER = "\u0000:\u0000"
const val PIN_STRING_NAME = "action_menu_pin_conversation"

class ChatMenuModifier(context: FeatureContext) : Feature(context) {

    private val plugins = mutableMapOf<String, MenuPlugin>()

    override fun init() {
        registerPlugin(PreviewOption(context))
        registerPlugin(ExportOption(context))

        val pinTextResource = context.appContext.resources.getIdentifier(
            PIN_STRING_NAME,
            "string",
            Shared.SNAPCHAT_PACKAGE
        )
        registerConversationToggle("pinning", pinTextResource) { it.pinned }
        registerConversationToggle("stealth", menu_option_stealth_mode) { it.stealth }
        registerConversationToggle("auto_save", menu_option_auto_save) { it.autoSave }
        registerConversationToggle("anti_auto_save", menu_option_anti_auto_save) { it.anti_autoSave }
        registerConversationToggle("auto_download", menu_option_auto_download) { it.autoDownload }
    }

    private fun registerConversationToggle(name: String, textResource: Int, manager: Manager) {
        registerPlugin(ConversationToggleOption(context, name, textResource, manager))
    }

    private fun registerPlugin(plugin: MenuPlugin) {
        plugins[plugin.name] = plugin
    }

    override fun performHooks() {
        // Add plugin actions to chat action menu.
        FriendChatActionMenuBuilder.call.after {
            val self = FriendChatActionMenuBuilder.wrap(it.thisObject)
            if (!FeedInfoHolder.isInstance(self.feedInfoHolder) || it.result !is ArrayList<*>) return@after

            val options = it.result as ArrayList<Any>
            val key = FeedInfoHolder.wrap(self.feedInfoHolder).feedKey

            val subOptions = plugins.values.filter(MenuPlugin::shouldCreate).map { p ->
                p.createModel(key)
            }

            options.addAll(subOptions);
        }

        // Override plugin action events.
        FriendChatActionHandler.handle.before {
            if (!SendChatAction.isInstance(it.args[0])) return@before

            val action = SendChatAction.wrap(it.args[0])
            val data = action.dataModel.key
            val parts = data.split(EVENT_DELIMITER)
            if (parts[0] == EVENT_PREFIX && parts.size == 3) {
                val pluginName = parts[1]
                plugins[pluginName]?.let { p ->
                    p.handleEvent(parts[2])
                    it.result = null
                }
            }
        }

        plugins.values.forEach(MenuPlugin::performHooks)
    }
}