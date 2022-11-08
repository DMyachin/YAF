package xyz.myachin.yaf.ui.tView.highlevel

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher.EmCompoundButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction.EvCompoundButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector.UbCompoundButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector.UsCompoundButtonGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TICompoundButtonGeneric

/** Описывает вью, которая имеет состояния `checked` или `unchecked`:
 * - радиобаттон
 * - чекбокс
 * - переключатель (свитч) */
class TCompoundButtonGeneric(private val tView: TICompoundButtonGeneric) : TICompoundButtonGeneric {
    companion object {
        /** `UIAutomator API`: Создать из [UiObject] */
        fun fromObject(uiObject: UiObject): TICompoundButtonGeneric {
            return UsCompoundButtonGenericImpl(uiObject)
        }

        /** `UIAutomator API`: Создать из [UiObject2] */
        fun fromObject(uiObject2: UiObject2): TICompoundButtonGeneric {
            return UbCompoundButtonGenericImpl(uiObject2)
        }

        /** `UIAutomator API`: Создать из [UiSelector] */
        fun fromSelector(uiSelector: UiSelector): TICompoundButtonGeneric {
            return UsCompoundButtonGenericImpl(uiSelector)
        }

        /** `UIAutomator API`: Создать из [BySelector] */
        fun fromSelector(bySelector: BySelector): TICompoundButtonGeneric {
            return UbCompoundButtonGenericImpl(bySelector)
        }

        /** `Espresso API`: Создать из [Matcher] */
        fun fromView(matcher: Matcher<View>): TICompoundButtonGeneric {
            return EmCompoundButtonGenericImpl(matcher)
        }

        /** `Espresso API`: Создать из [ViewInteraction] */
        fun fromView(vi: ViewInteraction): TICompoundButtonGeneric {
            return EvCompoundButtonGenericImpl(vi)
        }
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

    override fun isChecked(timeout: Long) {
        tView.isChecked(timeout)
    }

    override fun isUnchecked(timeout: Long) {
        tView.isUnchecked(timeout)
    }

    override fun getCheckState(): Boolean {
        return tView.getCheckState()
    }

    override fun tap() {
        tView.tap()
    }

    override fun longTap() {
        tView.longTap()
    }

    override fun contentDesc(): String {
        return tView.contentDesc()
    }
}