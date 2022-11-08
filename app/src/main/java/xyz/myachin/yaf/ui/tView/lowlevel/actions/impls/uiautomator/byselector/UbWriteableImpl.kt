package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable

class UbWriteableImpl(private val uView: UiObject2) : TIWriteable {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))

    override fun setText(text: String) {
        uView.text = text
    }

    override fun clearText() {
        uView.clear()
    }
}