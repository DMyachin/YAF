package xyz.myachin.yaf.ui.tView.highlevel

import android.view.View
import androidx.test.espresso.ViewInteraction
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2
import androidx.test.uiautomator.UiSelector
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher.EmContainerGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction.EvContainerGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector.UbContainerGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector.UsContainerGenericImpl
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIContainerGeneric

/** Описывает вью, которая содержит дочерние объекты, то есть является контейнером/вью групп:
 * - список
 * - контейнер */
class TContainerGeneric(private val tView: TIContainerGeneric) : TIContainerGeneric {
    companion object {
        /** `UIAutomator API`: Создать из [UiObject] */
        fun fromObject(uiObject: UiObject): TIContainerGeneric {
            return UsContainerGenericImpl(uiObject)
        }

        /** `UIAutomator API`: Создать из [UiObject2] */
        fun fromObject(uiObject2: UiObject2): TIContainerGeneric {
            return UbContainerGenericImpl(uiObject2)
        }

        /** `UIAutomator API`: Создать из [UiSelector] */
        fun fromSelector(uiSelector: UiSelector): TIContainerGeneric {
            return UsContainerGenericImpl(uiSelector)
        }

        /** `UIAutomator API`: Создать из [BySelector] */
        fun fromSelector(bySelector: BySelector): TIContainerGeneric {
            return UbContainerGenericImpl(bySelector)
        }

        /** `Espresso API`: Создать из [Matcher] */
        fun fromView(matcher: Matcher<View>): TIContainerGeneric {
            return EmContainerGenericImpl(matcher)
        }

        /** `Espresso API`: Создать из [ViewInteraction] */
        fun fromView(vi: ViewInteraction): TIContainerGeneric {
            return EvContainerGenericImpl(vi)
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

    override fun childrenCountIs(count: Int) {
        tView.childrenCountIs(count)
    }

    override fun childrenCountAtLeast(count: Int) {
        tView.childrenCountAtLeast(count)
    }

    override fun childrenCount(): Int {
        return tView.childrenCount()
    }

    override fun contentDesc(): String {
        return tView.contentDesc()
    }
}