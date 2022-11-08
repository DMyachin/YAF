package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import xyz.myachin.yaf.core.wait.TWait
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EViewHasTextImpl(private val vi: ViewInteraction) : TIViewHasText {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun text(): String {
        lateinit var result: String
        vi.check(ViewAssertions.matches(Matchers.instanceOf(TextView::class.java)))
            .check { view, noViewFoundException ->
                val txt = (view as TextView).text
                result = txt?.toString() ?: throw noViewFoundException
            }
        return result
    }

    override fun textIs(text: String, timeout: Long) {
        TWait.forViewInteraction(
            vi,
            ViewAssertions.matches(ViewMatchers.withText(text)),
            timeout
        )
    }

    override fun textContains(text: String, timeout: Long) {
        TWait.forViewInteraction(
            vi,
            ViewAssertions.matches(ViewMatchers.withSubstring(text)),
            timeout
        )
    }
}