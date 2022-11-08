package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class EViewHasChildrenImpl(private val vi: ViewInteraction) : TIViewHasChildren {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun childrenCountIs(count: Int) {
        vi.check(ViewAssertions.matches(ViewMatchers.hasChildCount(count)))
    }

    override fun childrenCountAtLeast(count: Int) {
        vi.check(ViewAssertions.matches(ViewMatchers.hasMinimumChildCount(count)))
    }

    override fun childrenCount(): Int {
        var count = 0
        vi.check { view, noViewFoundException ->
            if (noViewFoundException != null) throw noViewFoundException
            count = (view as ViewGroup).childCount
        }
        return count
    }
}