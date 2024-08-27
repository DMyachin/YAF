package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable

class UsWriteableImpl(private val uView: UiObject) : TIWriteable {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))

    override fun setText(text: String) {
        uView.setText(text)
    }

    override fun clearText() {
        uView.clearTextField()
    }
}