package xyz.myachin.yaf.core.framework

/** Base rule */
interface TBaseRule {

    /** You must return [TBaseRuleImpl] here. Also remember `@Rule`! */
    fun baseRule(): TBaseRuleImpl
}