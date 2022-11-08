package xyz.myachin.yaf.core.framework

/** Базовый интерфейс для всех автотестов. Здесь происходят гарантированные (нужные ВСЕМ) настройки */
interface TBaseRule {

    /** Для реализации метода нужно использовать [TBaseRuleImpl]. Не забывайте об аннотации `@Rule`! */
    fun baseRule(): TBaseRuleImpl
}