package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIStubViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class UbStubViewGenericImpl(uiObject2: UiObject2) : TIStubViewGeneric,
    TIViewGeneric by UbViewGenericImpl(uiObject2) {
    constructor(bySelector: BySelector) : this(TOs.tDevice.findObject(bySelector))
}