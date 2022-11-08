package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction

import androidx.test.espresso.ViewInteraction
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIContainerGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasChildrenImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class EvContainerGenericImpl(vi: ViewInteraction) : TIContainerGeneric,
    TIViewGeneric by EViewGenericImpl(vi),
    TIViewHasChildren by EViewHasChildrenImpl(vi)