package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class EViewGenericImpl(private val eView: ViewInteraction) : TIViewGeneric {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun getExistsState(): Boolean {
        var state = false
        try {
            eView.check(ViewAssertions.matches(Matchers.instanceOf(View::class.java)))
                .check { view, noViewFoundException ->
                    state = (noViewFoundException == null && view.javaClass.name.isNotBlank())
                }
        } catch (_: androidx.test.espresso.NoMatchingViewException) {
            return state
        }
        return state
    }

    override fun isExists(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(ViewMatchers.isDisplayed()),
            timeout
        )
    }

    override fun isNotExists(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.doesNotExist(),
            timeout
        )
    }

    override fun isVisible(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)),
            timeout
        )
    }

    override fun isGone(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())),
            timeout
        )
    }

    override fun isEnabled(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(ViewMatchers.isEnabled()),
            timeout
        )
    }

    override fun isDisabled(timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(Matchers.not(ViewMatchers.isEnabled())),
            timeout
        )
    }

    override fun isContentDescription(text: String, timeout: Long) {
        TWait.forViewInteraction(
            eView,
            ViewAssertions.matches(ViewMatchers.withContentDescription(text)),
            timeout
        )
    }

    override fun contentDesc(): String {
        var result = ""
        eView.check(ViewAssertions.matches(Matchers.instanceOf(View::class.java)))
            .check { view, noViewFoundException ->
                noViewFoundException?.run {
                    throw this
                }
                result = view.contentDescription.toString()
            }
        return result
    }
}