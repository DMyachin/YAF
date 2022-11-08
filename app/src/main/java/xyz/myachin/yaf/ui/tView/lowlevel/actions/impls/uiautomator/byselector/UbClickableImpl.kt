package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable

class UbClickableImpl(private val uView: UiObject2) : TIClickable {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))

    override fun tap() {
        uView.click()
    }

    override fun longTap() {
        uView.longClick()
    }
}