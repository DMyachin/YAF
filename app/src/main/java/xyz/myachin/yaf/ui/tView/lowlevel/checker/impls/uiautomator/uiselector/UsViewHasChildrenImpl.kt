package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.uiselector

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class UsViewHasChildrenImpl(private val tView: UiObject) : TIViewHasChildren {
    constructor(uiSelector: UiSelector) : this(TOs.tDevice.findObject(uiSelector))

    override fun childrenCountIs(count: Int) {
        tView.childCount.let {
            assert(it == count) { "Expected $count children but got $it" }
        }
    }

    override fun childrenCountAtLeast(count: Int) {
        tView.childCount.let {
            assert(it >= count) { "Expected at least $count children but got $it" }
        }
    }

    override fun childrenCount(): Int {
        return tView.childCount
    }
}