package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction

import androidx.test.espresso.ViewInteraction
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TICompoundButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasCompoundButtonImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class EvCompoundButtonGenericImpl(vi: ViewInteraction) : TICompoundButtonGeneric,
    TIViewGeneric by EViewGenericImpl(vi),
    TIViewHasCompoundButton by EViewHasCompoundButtonImpl(vi),
    TIClickable by EClickableImpl(vi)