package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.uiselector.UsClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UsButtonGenericImpl(uiObject: UiObject) : TIButtonGeneric,
    TIViewGeneric by UsViewGenericImpl(uiObject),
    TIClickable by UsClickableImpl(uiObject),
    TIViewHasText by UsViewHasTextImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))
}