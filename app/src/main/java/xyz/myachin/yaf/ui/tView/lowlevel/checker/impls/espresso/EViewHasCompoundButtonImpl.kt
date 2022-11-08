package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso

import android.view.View
import android.widget.CompoundButton
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class EViewHasCompoundButtonImpl(private val vi: ViewInteraction) :
    TIViewHasCompoundButton {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun isChecked(timeout: Long) {
        TWait.forViewInteraction(vi, ViewAssertions.matches(ViewMatchers.isChecked()), timeout)
    }

    override fun isUnchecked(timeout: Long) {
        TWait.forViewInteraction(
            vi,
            ViewAssertions.matches(ViewMatchers.isNotChecked()),
            timeout
        )
    }

    override fun getCheckState(): Boolean {
        var result = false

        vi.check(ViewAssertions.matches(Matchers.instanceOf(CompoundButton::class.java)))
            .check { view, e ->
                val bt = view as CompoundButton
                try {
                    result = bt.isChecked
                } catch (_: Exception) {
                    throw e
                }
            }
        return result
    }
}