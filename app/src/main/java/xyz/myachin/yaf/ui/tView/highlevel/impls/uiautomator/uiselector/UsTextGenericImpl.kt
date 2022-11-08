package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UsTextGenericImpl(uiObject: UiObject) : TITextGeneric,
    TIViewHasText by UsViewHasTextImpl(uiObject),
    TIViewGeneric by UsViewGenericImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))
}