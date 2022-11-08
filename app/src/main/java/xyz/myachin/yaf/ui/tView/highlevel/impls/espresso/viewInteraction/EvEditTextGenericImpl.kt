package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.viewInteraction

import androidx.test.espresso.ViewInteraction
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIEditTextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EWriteableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EvEditTextGenericImpl(vi: ViewInteraction) : TIEditTextGeneric,
    TIViewHasText by EViewHasTextImpl(vi),
    TIWriteable by EWriteableImpl(vi),
    TIViewGeneric by EViewGenericImpl(vi)