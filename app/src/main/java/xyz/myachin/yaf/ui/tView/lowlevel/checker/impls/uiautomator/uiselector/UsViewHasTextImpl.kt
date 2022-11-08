package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import org.junit.Assert
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UsViewHasTextImpl(private val uView: UiObject) : TIViewHasText {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))

    override fun text(): String {
        return uView.text
    }

    override fun textIs(text: String, timeout: Long) {
        Assert.assertEquals(text, uView.text)
    }

    override fun textContains(text: String, timeout: Long) {
        TWait.forUiObjectText(uView, UiObject::getText, text, timeout)
    }
}