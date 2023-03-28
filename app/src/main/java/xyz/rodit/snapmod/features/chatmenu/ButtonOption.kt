package xyz.rodit.snapmod.features.chatmenu

import xyz.rodit.snapmod.features.FeatureContext
import xyz.rodit.snapmod.mappings.*

abstract class ButtonOption(context: FeatureContext, name: String, private val textResource: Int) :
    MenuPlugin(context, name) {

    override fun createModel(key: String?): Any {
        val actionDataModel = SendChatActionDataModel(createEventData(key!!), false)
        val action = SendChatAction(actionDataModel)
        val textViewModel = ActionMenuOptionTextViewModel(textResource, null, null, null, null, 62)
        return ActionMenuOptionItemViewModel(
            textViewModel,
            ActionMenuActionModel(arrayOf(action.instance)),
            null,
            null,
            null,
            null,
            null,
            ActionMenuOptionItemType.OPTION_ITEM(),
            0
        ).instance
    }
}