package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher

import android.view.View
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIEditTextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.espresso.EWriteableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class EmEditTextGenericImpl(matcher: Matcher<View>) : TIEditTextGeneric,
    TIViewHasText by EViewHasTextImpl(matcher),
    TIWriteable by EWriteableImpl(matcher),
    TIViewGeneric by EViewGenericImpl(matcher)