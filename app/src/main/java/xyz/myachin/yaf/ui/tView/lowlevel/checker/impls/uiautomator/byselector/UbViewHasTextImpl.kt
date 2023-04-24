package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UbViewHasTextImpl(private val uView: UiObject2) : TIViewHasText {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))

    override fun text(): String {
        return uView.text
    }

    override fun textIs(text: String, timeout: Long) {
        TWait.forUiObject2TextIs(uView, UiObject2::getText, text, timeout)
    }

    override fun textContains(text: String, timeout: Long) {
        TWait.forUiObject2TextContains(uView, UiObject2::getText, text, timeout)
    }
}