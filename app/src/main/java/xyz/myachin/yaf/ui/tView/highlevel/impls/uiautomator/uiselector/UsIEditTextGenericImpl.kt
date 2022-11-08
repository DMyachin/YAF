package xyz.myachin.yaf.ui.tView.highlevel.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIEditTextGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.actions.impls.uiautomator.uiselector.UsWriteableImpl
import xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces.TIWriteable
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewGenericImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector.UsViewHasTextImpl
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasText

internal class UsIEditTextGenericImpl(uiObject: UiObject) : TIEditTextGeneric,
    TIViewHasText by UsViewHasTextImpl(uiObject),
    TIWriteable by UsWriteableImpl(uiObject),
    TIViewGeneric by UsViewGenericImpl(uiObject) {
    constructor(uiSelector: UiSelector) : this(tDevice.findObject(uiSelector))
}