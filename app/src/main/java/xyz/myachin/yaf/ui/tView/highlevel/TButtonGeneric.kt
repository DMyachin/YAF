package xyz.myachin.yaf.ui.tView.highlevel

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher.EmButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction.EvButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector.UbButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector.UsButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric

/** Описывает вью, которая имеет текст и клик на которую приводит к каким-то действиям:
 * - кнопка
 * - ссылка
 * - элемент меню
 * - элемент списка */
class TButtonGeneric(private val tView: TIButtonGeneric) : TIButtonGeneric {
    companion object {
        /** `UIAutomator API`: Создать из [UiObject] */
        fun fromObject(uiObject: UiObject): TIButtonGeneric {
            return UsButtonGenericImpl(uiObject)
        }

        /** `UIAutomator API`: Создать из [UiObject2] */
        fun fromObject(uiObject2: UiObject2): TIButtonGeneric {
            return UbButtonGenericImpl(uiObject2)
        }

        /** `UIAutomator API`: Создать из [UiSelector] */
        fun fromSelector(uiSelector: UiSelector): TIButtonGeneric {
            return UsButtonGenericImpl(uiSelector)
        }

        /** `UIAutomator API`: Создать из [BySelector] */
        fun fromSelector(bySelector: BySelector): TIButtonGeneric {
            return UbButtonGenericImpl(bySelector)
        }

        /** `Espresso API`: Создать из [Matcher] */
        fun fromView(matcher: Matcher<View>): TIButtonGeneric {
            return EmButtonGenericImpl(matcher)
        }

        /** `Espresso API`: Создать из [ViewInteraction] */
        fun fromView(vi: ViewInteraction): TIButtonGeneric {
            return EvButtonGenericImpl(vi)
        }
    }

    override fun tap() {
        tView.tap()
    }

    override fun longTap() {
        tView.longTap()
    }

    override fun text(): String {
        return tView.text()
    }

    override fun getExistsState(): Boolean {
        return tView.getExistsState()
    }

    override fun isExists(timeout: Long) {
        tView.isExists(timeout)
    }

    override fun isNotExists(timeout: Long) {
        tView.isNotExists(timeout)
    }

    override fun isVisible(timeout: Long) {
        tView.isVisible(timeout)
    }

    override fun isGone(timeout: Long) {
        tView.isGone(timeout)
    }

    override fun isEnabled(timeout: Long) {
        tView.isEnabled(timeout)
    }

    override fun isDisabled(timeout: Long) {
        tView.isDisabled(timeout)
    }

    override fun isContentDescription(text: String, timeout: Long) {
        tView.isContentDescription(text, timeout)
    }

    override fun textIs(text: String, timeout: Long) {
        tView.textIs(text, timeout)
    }

    override fun textContains(text: String, timeout: Long) {
        tView.textContains(text, timeout)
    }

    override fun contentDesc(): String {
        return tView.contentDesc()
    }
}