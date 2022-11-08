package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable

class EClickableImpl(private val vi: ViewInteraction) : TIClickable {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun tap() {
        vi.perform(ViewActions.click())
    }

    override fun longTap() {
        vi.perform(ViewActions.longClick())
    }
}