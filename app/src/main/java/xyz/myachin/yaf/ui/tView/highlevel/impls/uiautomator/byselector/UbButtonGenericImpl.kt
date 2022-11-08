package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.byselector.UbClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UbButtonGenericImpl(uiObject2: UiObject2) : TIButtonGeneric,
    TIViewGeneric by UbViewGenericImpl(uiObject2),
    TIClickable by UbClickableImpl(uiObject2),
    TIViewHasText by UbViewHasTextImpl(uiObject2) {
    constructor(bySelector: BySelector) : this(tDevice.findObject(bySelector))
}