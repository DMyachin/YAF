package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIStubViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

internal class UsStubViewGenericImpl(uiObject: UiObject) : TIStubViewGeneric,
    TIViewGeneric by UsViewGenericImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(TOs.tDevice.findObject(uiSelector))
}