package xyz.myachin.yaf.core.framework

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import xyz.myachin.yaf.core.device.TDevice
import xyz.myachin.yaf.core.os.shell.TShell

/** Выполняет базовые настройки устройства для автотестов */
class TBaseRuleImpl : TestRule {
    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                if (!TShell.isBootComplete) throw IllegalStateException("Critical property sys.boot_completed is not set")
                TDevice.wakeUp()
                TDevice.setOrientationNatural()

                TShell.setScreenTimeout(1_800_000) // 30 minutes

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