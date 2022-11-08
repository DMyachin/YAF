package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class UsViewHasCompoundButtonImpl(private val uView: UiObject) : TIViewHasCompoundButton {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))

    override fun isChecked(timeout: Long) {
        TWait.forUiObject(uView, UiObject::isChecked, timeout)
    }

    override fun isUnchecked(timeout: Long) {
        TWait.forUiObjectNot(uView, UiObject::isChecked, timeout)
    }

    override fun getCheckState(): Boolean {
        return uView.isChecked
    }
}