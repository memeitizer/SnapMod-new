<h1 align="center">
  <br>
  SnapMod2
  <br>
</h1>

<h4 align="center">Simple to use Xposed module for Snapchat 👻</h4>

<p align="center">
  <a href="https://github.com/RevealedSoulEven/Snapmod-new/releases">
    <img src="https://img.shields.io/github/v/release/RevealedSoulEven/Snapmod-new?style=for-the-badge"></a>
  <a href="https://github.com/RevealedSoulEven/Snapmod-new/releases"><img src="https://img.shields.io/github/downloads/RevealedSoulEven/Snapmod-new/total?style=for-the-badge"></a>
  <a href="https://github.com/RevealedSoulEven/Snapmod-new/stargazers">
    <img src="https://img.shields.io/github/stars/RevealedSoulEven/Snapmod-new?style=for-the-badge"></a>
</p>

<p align="center">
  <a href="#how-to-use">How To Use</a> •
  <a href="#key-features">Key Features</a> •
  <a href="#issues">Issue reporting</a> •
  <a href="#feature-request">Feature Requests</a>
</p>


# How To Use

To use this Xposed module, you'll need a rooted or a non-rooted phone (😱). 

## For both
* Please install a supported Snapchat version ([APKMirror](https://www.apkmirror.com/apk/snap-inc/snapchat/snapchat-12-26-0-20-release/snapchat-12-26-0-20-2-android-apk-download/) for example), currently the supported one is **12.26.0.20** for SnapMod 1.8.8. We do not offer official (You might get in GitHub issues) support for versions that are behind either one.
* > **Note** If you are an android developer or something similar, you can create mappings yourself that might work for higher/lower Snapchat versions. You can follow the steps in `.github/workflows`
* > **Note** If you have obtained custom mappings, move them in `/(Android|data)/data/xyz.rodit.snapmod/files/[build].json`. Build numbers you can obtain from APKMirror, if they are not provided. With a good file explorer (Like MiXplorer or File Manager Plus) non-rooted users can do this as well.

* > **Warning** We might not offer support for non-rooted users


## Need Guide or Direct APK for non-root users?
1. Join out [Telegram](https://t.me/snapmod) group
2. Or simply search ```@snapmod``` on Telegram

## Installation for non-rooted users (Advanced)
1. Download and install [LSPatch](https://github.com/LSPosed/LSPatch) and [Shizuku](https://github.com/RikkaApps/Shizuku)
2. Download and install [app-release.apk](https://github.com/RevealedSoulEven/SnapMod-new/releases/download/1.8.8/app-debug.apk) from latest release
3. Turn on Shizuku and open LSPatch and go to the second tab from the left
4. Press the plus sign and search Snapchat and select it
5. Choose the the Patch Mode to be Portable
6. Click on Embed modules and select SnapMod and tap Start Patch
7. Open SnapMod and verify that it says "Supported version". If it doesn't, try again. Make sure you have the correct mappings!

## Installation for root users
1. Download and install [LSPosed Framework](https://github.com/LSPosed/LSPosed). We do not offer support for other Xposed implementatios although SnapMod would work fine with them.
2. Download and install [app-release.apk](https://github.com/RevealedSoulEven/SnapMod-new/releases/download/1.8.8/app-debug.apk) from latest release.
3. Enable SnapMod in LSPosed manager and close Snapchat completely.
5. Open SnapMod and verify that it says "Supported version". If it doesn't, please see <a href="#issues">Issues</a>



## Key Features
> **Note** Full feature list and their status is available [here](https://github.com/rodit/Snapmod/wiki/Features)! More than 30 features available!
* Download Snaps and stories!
  - Save them automatically too!
  - Customizable behaviour
* Privacy
  - Disable notifications for certain activities for other people and Snapchat's metrics and logging
* Tweaks
  - Change how parts of Snapchat work, like removing ads or disabling the Spotlight tab
* Camera
  - Change image settings
  - Change video settings
* Snaps
  - Change the behaviour of incoming snaps
* Notifications
  - Incoming notification changing
* Miscellanous
  - Additional user info
  - Module update checking
* New(by SoulEven)
  - Fixed Video not sending issue
  - Fixed Preview/Export Chat
  - Set New Chat Menu as Default
  - More Hidden Chat Options
  - Option for Anti-Auto Save Messages
  - More options for Auto Save Messages
  - Removed useless and deprecated features


# Issues
> **Warning** Please do not create duplicate issues. Refrain from creating feature requests or common questions in our Issues or use **Telegram group** for these.

## Troubleshooting
If nothing works, the first thing to do is: kill the Snapchat app process through system settings and after that relaunch it and do this twice. This will make sure any cached mappings are updated.

## GitHub Issues
If you have encountered an issue: First check Github Issues if others have experienced it if not, please get logs from LSPosed and upload them while creating a new issue. Please describe the bug, give us steps to reproduce, screenshots, expected behaviour and any additional context you might have.

# Feature request
If you have an idea for a new feature, please check **Discussions** tab first if it has been requested already. If it has not, create one!

# Donate
If you would like to support the deveploment of SnapMod, you can do it by donating
> **Note** These donations are not made to me, but to the original developer @rodit
* [PayPal](https://paypal.me/roditmod) 
* [Cashapp](https://cash.app/rodit9)
