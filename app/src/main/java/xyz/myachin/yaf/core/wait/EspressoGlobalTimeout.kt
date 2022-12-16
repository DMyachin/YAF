package xyz.myachin.yaf.core.wait

import androidx.test.espresso.IdlingPolicies
import java.util.concurrent.TimeUnit

object EspressoGlobalTimeout {
    fun launchLongTask(timeout: Long = 5, timeUnit: TimeUnit = TimeUnit.MINUTES, code: () -> Any) {
        val before = IdlingPolicies.getMasterIdlingPolicy()
        IdlingPolicies.setMasterPolicyTimeout(timeout, timeUnit)
        code()
        IdlingPolicies.setMasterPolicyTimeout(before.idleTimeout, before.idleTimeoutUnit)
    }
}