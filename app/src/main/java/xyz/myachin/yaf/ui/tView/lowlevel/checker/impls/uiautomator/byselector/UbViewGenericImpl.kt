package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector

import android.os.SystemClock
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.exceptions.TUiObject2StateFail
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class UbViewGenericImpl(private val uView: UiObject2) : TIViewGeneric {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))

    override fun getExistsState(): Boolean {
        return try {
            uView.className
            true
        } catch (_: Exception) {
            false
        }
    }

    override fun isExists(timeout: Long) {
        val end = SystemClock.elapsedRealtime() + timeout
        while (SystemClock.elapsedRealtime() <= end) {
            if (!uView.visibleBounds.isEmpty) return
        }
        throw TUiObject2StateFail(uView)
    }

    override fun isNotExists(timeout: Long) {
        val end = SystemClock.elapsedRealtime() + timeout
        while (SystemClock.elapsedRealtime() <= end) {
            if (uView.visibleBounds.isEmpty) return
        }
        throw TUiObject2StateFail(uView)
    }

    override fun isVisible(timeout: Long) {
        return isVisible(timeout)
    }

    override fun isGone(timeout: Long) {
        return isNotExists(timeout)
    }

    override fun isEnabled(timeout: Long) {
        TWait.forUiObject(uView, UiObject2::isEnabled, timeout)
    }

    override fun isDisabled(timeout: Long) {
        TWait.forUiObjectNot(uView, UiObject2::isEnabled, timeout)
    }

    override fun isContentDescription(text: String, timeout: Long) {
        TWait.forUiObjectText(uView, UiObject2::getContentDescription, text, timeout)
    }

    override fun contentDesc(): String {
        return uView.contentDescription
    }
}