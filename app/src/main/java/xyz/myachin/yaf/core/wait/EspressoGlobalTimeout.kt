package xyz.myachin.yaf.core.wait

import androidx.test.espresso.IdlingPolicies
import java.util.concurrent.TimeUnit

/** For Espresso only. Can be used when very long task executes and Espresso throws [androidx.test.espresso.AppNotIdleException]  */
object EspressoGlobalTimeout {

    /** Overrides [androidx.test.espresso.IdlingPolicy] with custom timeout only for [code] and restores defaults
     * @param timeout timeout for operation
     * @param timeUnit time unit (for example [java.util.concurrent.TimeUnit.MINUTES]) for [timeout]
     * @param code your code */
    fun launchLongTask(timeout: Long = 5, timeUnit: TimeUnit = TimeUnit.MINUTES, code: () -> Any) {
        val before = IdlingPolicies.getMasterIdlingPolicy()
        IdlingPolicies.setMasterPolicyTimeout(timeout, timeUnit)
        code()
        IdlingPolicies.setMasterPolicyTimeout(before.idleTimeout, before.idleTimeoutUnit)
    }
}