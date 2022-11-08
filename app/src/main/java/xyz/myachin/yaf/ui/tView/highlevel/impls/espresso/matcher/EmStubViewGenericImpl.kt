package xyz.myachin.yaf.ui.tView.highlevel.impls.espresso.matcher

import android.view.View
import org.hamcrest.Matcher
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIStubViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.espresso.EViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class EmStubViewGenericImpl(matcher: Matcher<View>) : TIStubViewGeneric,
    TIViewGeneric by EViewGenericImpl(matcher)