package xyz.myachin.yaf.core.os.ui.actions.launcher

/**
 * Для запуска приложений
 */
interface TLaunchable {
    /**
     * Запуск приложения или нужного экрана. Для запуска стартового экрана приложения можно вызывать
     * уже готовую реализацию [TLaunchableImpl]
     */
    fun launch()
}