package xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable

class EWriteableImpl(private val vi: ViewInteraction) : TIWriteable {
    constructor(matcher: Matcher<View>) : this(Espresso.onView(matcher))

    override fun setText(text: String) {
        vi.perform(ViewActions.replaceText(text))
    }

    override fun clearText() {
        vi.perform(ViewActions.clearText())
    }
}