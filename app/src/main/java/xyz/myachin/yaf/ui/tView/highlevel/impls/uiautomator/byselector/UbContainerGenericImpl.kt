package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIContainerGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector.UbViewHasChildrenImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class UbContainerGenericImpl(uiObject2: UiObject2) : TIContainerGeneric,
    TIViewHasChildren by UbViewHasChildrenImpl(uiObject2),
    TIViewGeneric by UbViewGenericImpl(uiObject2) {
    constructor(bySelector: BySelector) : this(TOs.tDevice.findObject(bySelector))
}