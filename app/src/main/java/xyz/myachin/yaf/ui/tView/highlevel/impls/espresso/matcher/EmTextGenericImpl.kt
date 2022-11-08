package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher

import android.view.View
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EmTextGenericImpl(matcher: Matcher<View>) : TITextGeneric,
    TIViewHasText by EViewHasTextImpl(matcher),
    TIViewGeneric by EViewGenericImpl(matcher)