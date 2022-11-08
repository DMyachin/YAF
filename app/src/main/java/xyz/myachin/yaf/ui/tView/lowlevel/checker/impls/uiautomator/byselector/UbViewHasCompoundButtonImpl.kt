package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class UbViewHasCompoundButtonImpl(private val uView: UiObject2) : TIViewHasCompoundButton {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))

    override fun isChecked(timeout: Long) {
        TWait.forUiObject(uView, UiObject2::isChecked, timeout)
    }

    override fun isUnchecked(timeout: Long) {
        TWait.forUiObjectNot(uView, UiObject2::isChecked, timeout)
    }

    override fun getCheckState(): Boolean {
        return uView.isChecked
    }
}