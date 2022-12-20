package xyz.myachin.yaf.core.os.ui.actions

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import xyz.myachin.yaf.core.T_EXTENDED_WAIT
import xyz.myachin.yaf.core.T_LONG_WAIT
import xyz.myachin.yaf.core.device.TDevice
import xyz.myachin.yaf.core.exceptions.TLaunchActivityNotExistsError
import xyz.myachin.yaf.core.os.TOs.TAppContext
import xyz.myachin.yaf.core.os.TOs.TPackageManager
import xyz.myachin.yaf.core.os.TOs.tDevice
import xyz.myachin.yaf.ui.selector.lowlevel.TSelector
import xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces.TIViewGeneric

/** Действия, которые связаны с ОС и видны пользователю */
object TOsUiAction {
    private const val TAG = "TOsUiActions"

    private const val defaultFlags = Intent.FLAG_ACTIVITY_NEW_TASK or
            Intent.FLAG_ACTIVITY_CLEAR_TASK or
            Intent.FLAG_ACTIVITY_NO_HISTORY or
            Intent.FLAG_ACTIVITY_NO_ANIMATION

    /** Запускает приложение типа тапом по иконке. Нельзя использовать для запуска приложений-обёрток в Espresso.
     * @see [launchSelf] */
    fun startLaunchActivityAsUser(selector: TSelector) {
        TPackageManager.getLaunchIntentForPackage(selector.appPackage)?.run {
            addFlags(defaultFlags)
            TAppContext.startActivity(this)
            return
        }
        throw TLaunchActivityNotExistsError(selector.appPackage)
    }

    /** Запускает приложение-обёртку. Используется только для Espresso
     * @see startLaunchActivityAsUser */
    fun launchSelf() {
        val flg = defaultFlags and
                Intent.FLAG_ACTIVITY_CLEAR_TASK and
                Intent.FLAG_ACTIVITY_NO_HISTORY
        TPackageManager.getLaunchIntentForPackage(TAppContext.packageName)?.run {
            addFlags(flg)
            TAppContext.startActivity(this)
            return
        }
        throw TLaunchActivityNotExistsError(TAppContext.packageName)
    }

    fun startActivity(intent: Intent, bundle: Bundle?) {
        intent.run {
            addFlags(defaultFlags)
            TAppContext.startActivity(this, bundle)
        }
    }

    /** Послать бродкаст */
    fun sendBroadcast(intent: Intent, receiverPermission: String? = null) {
        TAppContext.sendBroadcast(intent, receiverPermission)
    }

    fun openNotifications(timeout: Long = T_LONG_WAIT) {
        tDevice.openNotification()
        SystemClock.sleep(timeout)
    }

    fun openQuickSettings(timeout: Long = T_EXTENDED_WAIT) {
        tDevice.openQuickSettings()
        SystemClock.sleep(timeout)
    }

    /** Выйти из приложения [fromPkg] по нажатию на кнопку Back */
    fun exitFromApp(fromPkg: String, attempts: Int = 5) {
        repeat(attempts) {
            TDevice.pressDeviceBackButton()
            SystemClock.sleep(500)
            if (tDevice.currentPackageName != fromPkg) return
        }
        Log.e(TAG, "exitToLauncher: it is possible cannot exit")
    }

    /** Выйти из приложения [application] по нажатию на кнопку Back */
    fun exitFromApp(application: TSelector, attempts: Int = 5) {
        exitFromApp(application.appPackage, attempts)
    }

    /** Нажимая кнопку Back, попытаться выйти к лончеру */
    fun exitToLauncher(attempts: Int = 5) {
        val startPkg = tDevice.currentPackageName
        repeat(attempts) {
            if (tDevice.currentPackageName == tDevice.launcherPackageName) return
            TDevice.pressDeviceBackButton()
            SystemClock.sleep(500)
        }
        Log.e(TAG, "exitToLauncher: it is possible cannot exit from $startPkg")
    }

    /** Прокрутка по экрану устройства вверх до нужного [view] за [attempts] попыток */
    fun scrollUpTo(view: TIViewGeneric, attempts: Int = 3) {
        repeat(attempts) { counter ->
            try {
                view.isExists()
                return
            } catch (exception: Exception) {
                if (attempts == counter + 1) throw exception //счётчик идёт с 0
                TDevice.swipeUp()
            }
        }
    }
}