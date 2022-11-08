package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction

import androidx.test.espresso.ViewInteraction
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIStubViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class EvStubViewGenericImpl(vi: ViewInteraction) : TIStubViewGeneric,
    TIViewGeneric by EViewGenericImpl(vi)