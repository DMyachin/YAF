package xyz.myachin.yaf.core.os.shell

import xyz.myachin.yaf.core.os.TOs.tDevice

internal object TShell {
    private fun shellCommand(command: String): String? {
        return tDevice.executeShellCommand(command)?.trim()
    }

    private fun suShellCommand(command: String): String? {
        return shellCommand("su 0 $command")
    }

    internal fun setDate(time: String) {
        suShellCommand("date $time set")
    }

    internal fun removeTree(fileName: String, recursive: Boolean) {
        shellCommand("rm $fileName" + if (recursive) " -rf" else "")
    }

    internal fun renameFile(oldName: String, newName: String) {
        shellCommand("mv $oldName $newName")
    }

    internal fun sendTimeSetBroadcast() {
        suShellCommand("am broadcast -a android.intent.action.TIME_SET")
    }

    internal fun getProcessesArgs(): String {
        return shellCommand("ps -e -o ARGS=CMD")!!
    }

    private fun bootComplete(): Boolean {
        shellCommand("getprop sys.boot_completed")?.let {
            return when (val res = it.trim().replace("\"", "").toInt()) {
                0 -> false
                1 -> true
                else -> throw IllegalArgumentException("Cannot use $res as value")
            }
        }
        return false
    }

    private fun putSetting(param: String): String? {
        return shellCommand("settings put $param")
    }

    private fun global(param: String, value: String): String? {
        return putSetting("global $param $value")
    }

    private fun system(param: String, value: String): String? {
        return putSetting("system $param $value")
    }

    internal var autoTime: Boolean
        get() = shellCommand("settings get global auto_time")?.trim() == "1"
        set(value) {
            global("auto_time", if (value) "1" else "0")
        }

    /** Critical property `sys.boot_completed` */
    internal val isBootComplete by lazy { bootComplete() }

    internal fun disableTransitionAnimationScale() {
        global("transition_animation_scale", "0")
    }

    internal fun disableWindowAnimationScale() {
        global("window_animation_scale", "0")
    }

    internal fun disableAnimatorDurationScale() {
        global("animator_duration_scale", "0")
    }

    internal fun showTouches() {
        system("show_touches", "1")
    }

    internal fun showPointerLocation() {
        system("pointer_location", "1")
    }

    internal fun setScreenTimeout(time: Long) {
        system("screen_off_timeout", "$time")
    }

    /** Set overlay params
     *
     * [state]: true means enable and false means disable
     *
     * [name]: param name
     * */
    private fun cmdOverlay(state: Boolean, name: String) {
        shellCommand("cmd overlay ${if (state) "enable" else "disable"} $name")
    }

    /** Add or remove padding in screen bottom. [state] is `true` for add and `false` for remove */
    private fun setNavbarGestural(state: Boolean) {
        cmdOverlay(state, "com.android.internal.systemui.navbar.gestural")
    }

    /** Enable ([state] is `true`) or disable ([state] is `false` navigation by 3 buttons */
    private fun setNavbar3Button(state: Boolean) {
        cmdOverlay(state, "com.android.internal.systemui.navbar.threebutton")
    }

    /** Method enables legacy navigation with 3 buttons */
    internal fun enable3ButtonsNavigation() {
        setNavbarGestural(false)
        setNavbar3Button(true)
    }
}