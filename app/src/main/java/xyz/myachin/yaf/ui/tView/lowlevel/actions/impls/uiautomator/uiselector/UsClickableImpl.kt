package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable

class UsClickableImpl(private val uView: UiObject) : TIClickable {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))

    override fun tap() {
        uView.click()
    }

    override fun longTap() {
        uView.longClick()
    }
}