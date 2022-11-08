package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher

import android.view.View
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TICompoundButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasCompoundButtonImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class EmCompoundButtonGenericImpl(matcher: Matcher<View>) : TICompoundButtonGeneric,
    TIViewGeneric by EViewGenericImpl(matcher),
    TIViewHasCompoundButton by EViewHasCompoundButtonImpl(matcher),
    TIClickable by EClickableImpl(matcher)