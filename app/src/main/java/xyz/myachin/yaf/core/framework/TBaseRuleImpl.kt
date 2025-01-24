package xyz.myachin.yaf.core.framework

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import xyz.myachin.yaf.core.T_MINUTE
import xyz.myachin.yaf.core.device.TDevice
import xyz.myachin.yaf.core.os.shell.TShell

/** All tests must use this rule */
class TBaseRuleImpl : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                if (!TShell.isBootComplete) throw IllegalStateException("Critical property sys.boot_completed is not set")
                TShell.disableAdbVerifier()
                TShell.setScreenTimeout(30 * T_MINUTE)

                TDevice.uiDevice.wakeUp()
                TDevice.uiDevice.setOrientationNatural()

                TShell.enable3ButtonsNavigation()
                TShell.disableTransitionAnimationScale()
                TShell.disableWindowAnimationScale()
                TShell.disableAnimatorDurationScale()

                TShell.showPointerLocation()
                TShell.showTouches()
                base.evaluate()
            }
        }
    }
}