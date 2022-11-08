package xyz.myachin.yaf.ui.tView.highlevel

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher.EmEditTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction.EvEditTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector.UbEditTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector.UsIEditTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIEditTextGeneric

/** Описывает вью, которая может содержать редактируемый текст:
 * - EditText */
class TEditTextGeneric(private val tView: TIEditTextGeneric) : TIEditTextGeneric {
    companion object {
        /** `UIAutomator API`: Создать из [UiObject] */
        fun fromObject(uiObject: UiObject): TIEditTextGeneric {
            return UsIEditTextGenericImpl(uiObject)
        }

        /** `UIAutomator API`: Создать из [UiObject2] */
        fun fromObject(uiObject2: UiObject2): TIEditTextGeneric {
            return UbEditTextGenericImpl(uiObject2)
        }

        /** `UIAutomator API`: Создать из [UiSelector] */
        fun fromSelector(uiSelector: UiSelector): TIEditTextGeneric {
            return UsIEditTextGenericImpl(uiSelector)
        }

        /** `UIAutomator API`: Создать из [BySelector] */
        fun fromSelector(bySelector: BySelector): TIEditTextGeneric {
            return UbEditTextGenericImpl(bySelector)
        }

        /** `Espresso API`: Создать из [Matcher] */
        fun fromView(matcher: Matcher<View>): TIEditTextGeneric {
            return EmEditTextGenericImpl(matcher)
        }

        /** `Espresso API`: Создать из [ViewInteraction] */
        fun fromView(vi: ViewInteraction): TIEditTextGeneric {
            return EvEditTextGenericImpl(vi)
        }
    }

    override fun text(): String {
        return tView.text()
    }

    override fun textIs(text: String, timeout: Long) {
        tView.textIs(text, timeout)
    }

    override fun textContains(text: String, timeout: Long) {
        tView.textContains(text, timeout)
    }

    override fun setText(text: String) {
        tView.setText(text)
    }

    override fun clearText() {
        tView.clearText()
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

    override fun contentDesc(): String {
        return tView.contentDesc()
    }
}