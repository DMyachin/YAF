package xyz.myachin.yaf.core.exceptions

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiObject2

open class TException(message: String) : Exception(message)

class TLaunchActivityNotExistsError(pkgName: String) :
    TException("Package $pkgName has not own launch activity")

class TUiObjectStateFail(uiObject: UiObject) :
    TException("uiObject \"${uiObject.selector}\" condition is unacceptable")

class TUiObject2StateFail(uiObject2: UiObject2) :
    TException("uiObject \"${uiObject2.className}\" condition is unacceptable")

class TDateTimeParseFail(format: String, dateTime: String) :
    TException("Cannot parse '$dateTime' as '$format'")