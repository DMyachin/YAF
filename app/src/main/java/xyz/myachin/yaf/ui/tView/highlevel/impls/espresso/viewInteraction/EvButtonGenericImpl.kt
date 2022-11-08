package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction

import androidx.test.espresso.ViewInteraction
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EvButtonGenericImpl(vi: ViewInteraction) : TIButtonGeneric,
    TIViewGeneric by EViewGenericImpl(vi),
    TIClickable by EClickableImpl(vi),
    TIViewHasText by EViewHasTextImpl(vi)