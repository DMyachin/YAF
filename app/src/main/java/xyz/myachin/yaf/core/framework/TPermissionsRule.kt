package xyz.myachin.yaf.core.framework

import androidx.test.rule.GrantPermissionRule

/** Интерфейс работает только с Espresso. Выдаёт пермишены приложению */
interface TPermissionsRule {

    /** Выдать нужные пермишены приложению. Не забывайте ставить аннотацию `@Rule`! */
    fun grantPermissions(): GrantPermissionRule
}