package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TICompoundButtonGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.uiselector.UsClickableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIClickable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewHasCompoundButtonImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasCompoundButton

internal class UsCompoundButtonGenericImpl(uiObject: UiObject) : TICompoundButtonGeneric,
    TIViewGeneric by UsViewGenericImpl(uiObject),
    TIViewHasCompoundButton by UsViewHasCompoundButtonImpl(uiObject),
    TIClickable by UsClickableImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))
}