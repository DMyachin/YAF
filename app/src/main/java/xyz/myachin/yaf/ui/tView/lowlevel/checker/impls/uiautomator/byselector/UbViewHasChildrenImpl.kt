package xyz.myachin.yaf.ui.tView.lowlevel.checker.impls.uiautomator.byselector

import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiObject2
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewHasChildren

internal class UbViewHasChildrenImpl(private val uView: UiObject2) : TIViewHasChildren {
    constructor(bySelector: BySelector) : this(TOs.tDevice.findObject(bySelector))

    override fun childrenCountIs(count: Int) {
        uView.childCount.let { c ->
            assert(c == count) { "Expected children $count but got $c" }
        }
    }

    override fun childrenCountAtLeast(count: Int) {
        uView.childCount.let { c ->
            assert(c >= count) { "Expected at least $count children but got $c" }
        }
    }

    override fun childrenCount(): Int {
        return uView.childCount
    }
}