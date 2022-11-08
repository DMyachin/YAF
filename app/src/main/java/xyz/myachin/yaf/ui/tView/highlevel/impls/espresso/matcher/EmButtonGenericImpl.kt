package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher

import android.view.View
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EmButtonGenericImpl(matcher: Matcher<View>) : TIButtonGeneric,
    TIViewGeneric by EViewGenericImpl(matcher),
    TIClickable by EClickableImpl(matcher),
    TIViewHasText by EViewHasTextImpl(matcher)