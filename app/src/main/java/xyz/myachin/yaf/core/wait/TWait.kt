package xyz.myachin.yaf.core.wait

import android.os.SystemClock
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.exceptions.TUiObject2StateFail
import xyz.myachin.yaf.core.exceptions.TUiObjectStateFail

internal object TWait {
    private fun end(timeout: Long): Long {
        return SystemClock.elapsedRealtime() + timeout
    }

    internal fun forViewInteraction(eView: ViewInteraction, matches: ViewAssertion, timeout: Long) {
        val end = end(timeout)
        while (true) {
            try {
                eView.check(matches)
                return
            } catch (err: Throwable) {
                if (SystemClock.elapsedRealtime() >= end) throw err
            }
        }
    }

    internal fun forUiObject(uView: UiObject, uiFunc: (UiObject) -> Boolean, timeout: Long) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView)) return
        }
        throw TUiObjectStateFail(uView)
    }

    internal fun forUiObject(uView: UiObject2, uiFunc: (UiObject2) -> Boolean, timeout: Long) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView)) return
        }
        throw TUiObject2StateFail(uView)
    }

    internal fun forUiObjectNot(
        uView: UiObject,
        uiFunc: (UiObject, Long) -> Boolean,
        timeout: Long
    ) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (!uiFunc(uView, 0)) return
        }
        throw TUiObjectStateFail(uView)
    }

    internal fun forUiObjectNot(uView: UiObject, uiFunc: (UiObject) -> Boolean, timeout: Long) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (!uiFunc(uView)) return
        }
        throw TUiObjectStateFail(uView)
    }

    internal fun forUiObjectNot(uView: UiObject2, uiFunc: (UiObject2) -> Boolean, timeout: Long) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (!uiFunc(uView)) return
        }
        throw TUiObject2StateFail(uView)
    }

    internal fun forUiObjectTextContains(
        uView: UiObject,
        uiFunc: (UiObject) -> String,
        text: String,
        timeout: Long
    ) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView).contains(text)) return
        }
        throw TUiObjectStateFail(uView)
    }

    internal fun forUiObjectTextIs(
        uView: UiObject,
        uiFunc: (UiObject) -> String,
        text: String,
        timeout: Long
    ) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView) == text) return
        }
        throw TUiObjectStateFail(uView)
    }

    internal fun forUiObject2TextIs(
        uView: UiObject2,
        uiFunc: (UiObject2) -> String,
        text: String,
        timeout: Long
    ) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView) == text) return
        }
        throw TUiObject2StateFail(uView)
    }

    internal fun forUiObject2TextContains(
        uView: UiObject2,
        uiFunc: (UiObject2) -> String,
        text: String,
        timeout: Long
    ) {
        val end = end(timeout)
        while (SystemClock.elapsedRealtime() <= end) {
            if (uiFunc(uView).contains(text)) return
        }
        throw TUiObject2StateFail(uView)
    }
}

