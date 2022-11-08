package xyz.myachin.yaf.core.os.ui.actions.launcher

import xyz.myachin.yaf.core.os.ui.actions.TOsUiAction
import xyz.myachin.yaf.ui.selector.lowlevel.TSelector

class TLaunchableImpl(private val selector: TSelector) : TLaunchable {
    override fun launch() {
        TOsUiAction.startLaunchActivityAsUser(selector)
    }
}