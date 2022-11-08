package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UbTextGenericImpl(uiObject2: UiObject2) : TITextGeneric,
    TIViewHasText by UbViewHasTextImpl(uiObject2),
    TIViewGeneric by UbViewGenericImpl(uiObject2) {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))
}