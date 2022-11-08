package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.exceptions.TUiObjectStateFail
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class UsViewGenericImpl(private val uView: UiObject) : TIViewGeneric {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))

    override fun getExistsState(): Boolean {
        return uView.exists()
    }

    override fun isExists(timeout: Long) {
        if (!uView.waitForExists(timeout)) throw TUiObjectStateFail(uView)
    }

    override fun isNotExists(timeout: Long) {
        TWait.forUiObjectNot(uView, UiObject::waitForExists, timeout)
    }

    override fun isVisible(timeout: Long) {
        return isExists(timeout)
    }

    override fun isGone(timeout: Long) {
        if (!uView.waitUntilGone(timeout)) throw TUiObjectStateFail(uView)
    }

    override fun isEnabled(timeout: Long) {
        TWait.forUiObject(uView, UiObject::isEnabled, timeout)
    }

    override fun isDisabled(timeout: Long) {
        TWait.forUiObjectNot(uView, UiObject::isEnabled, timeout)
    }

    override fun isContentDescription(text: String, timeout: Long) {
        TWait.forUiObjectText(uView, UiObject::getContentDescription, text, timeout)
    }

    override fun contentDesc(): String {
        return uView.contentDescription
    }
}