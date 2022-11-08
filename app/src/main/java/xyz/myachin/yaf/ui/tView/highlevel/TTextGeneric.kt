package xyz.myachin.yaf.ui.tView.highlevel

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher.EmTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction.EvTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector.UbTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector.UsTextGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric

/** Описывает вью, которая может содержать текст, но не позволяет его редактировать:
 * - обычные текст вью
 * - EditText, если нет необходимости редактировать
 * - кнопки, если нет нужды на них нажимать
 * - многое другое */
class TTextGeneric(private val tView: TITextGeneric) : TITextGeneric {
    companion object {
        /** `UIAutomator API`: Создать из [UiObject] */
        fun fromObject(uiObject: UiObject): TITextGeneric {
            return UsTextGenericImpl(uiObject)
        }

        /** `UIAutomator API`: Создать из [UiObject2] */
        fun fromObject(uiObject2: UiObject2): TITextGeneric {
            return UbTextGenericImpl(uiObject2)
        }

        /** `UIAutomator API`: Создать из [UiSelector] */
        fun fromSelector(uiSelector: UiSelector): TITextGeneric {
            return UsTextGenericImpl(uiSelector)
        }

        /** `UIAutomator API`: Создать из [BySelector] */
        fun fromSelector(bySelector: BySelector): TITextGeneric {
            return UbTextGenericImpl(bySelector)
        }

        /** `Espresso API`: Создать из [Matcher] */
        fun fromView(matcher: Matcher<View>): TITextGeneric {
            return EmTextGenericImpl(matcher)
        }

        /** `Espresso API`: Создать из [ViewInteraction] */
        fun fromView(vi: ViewInteraction): TITextGeneric {
            return EvTextGenericImpl(vi)
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
        tView.isEnabled(timeout)
    }

    override fun isContentDescription(text: String, timeout: Long) {
        tView.isContentDescription(text, timeout)
    }

    override fun contentDesc(): String {
        return tView.contentDesc()
    }

}