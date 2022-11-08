package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIContainerGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewHasChildrenImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class UsContainerGenericImpl(uiObject: UiObject) : TIContainerGeneric,
    TIViewGeneric by UsViewGenericImpl(uiObject),
    TIViewHasChildren by UsViewHasChildrenImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(TOs.tDevice.findObject(uiSelector))
}