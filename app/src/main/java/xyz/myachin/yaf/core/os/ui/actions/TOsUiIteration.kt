package xyz.myachin.yaf.core.os.ui.actions

import android.content.Intent
import android.util.Log
import xyz.myachin.yaf.core.device.TDevice
import xyz.myachin.yaf.core.exceptions.TLaunchActivityNotExistsError
import xyz.myachin.yaf.core.os.TOs.TPackageManager
import xyz.myachin.yaf.core.os.TOs.TTargetContext

object TOsUiIteration {
    private const val TAG = "YAF T_OS_UI_INTERACTION"
    private const val DEFAULT_FLAGS = Intent.FLAG_ACTIVITY_NEW_TASK or
        Intent.FLAG_ACTIVITY_CLEAR_TASK or
        Intent.FLAG_ACTIVITY_NO_HISTORY or
        Intent.FLAG_ACTIVITY_NO_ANIMATION

    /** It's like tap on app's icon in launcher
     * @see [startLaunchActivityAsUserNoHistory] */
    fun startLaunchActivityAsUser(packageName: String) {
        TPackageManager.getLaunchIntentForPackage(packageName)?.run {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            TTargetContext.startActivity(this)
            return
        }
        throw TLaunchActivityNotExistsError(packageName)
    }

    /** It's like tap on app's icon in launcher. But app will not be added to back stack
     * @see [startLaunchActivityAsUser] */
    fun startLaunchActivityAsUserNoHistory(packageName: String) {
        TPackageManager.getLaunchIntentForPackage(packageName)?.run {
            addFlags(DEFAULT_FLAGS)
            TTargetContext.startActivity(this)
            return
        }
        throw TLaunchActivityNotExistsError(packageName)
    }

    /** Tap `Back` button until exit from [packageName] but not more than [attempts] times */
    fun exitFromApp(packageName: String, attempts: Int = 5) {
        repeat(attempts) {
            TDevice.uiDevice.pressBack()
            if (TDevice.uiDevice.currentPackageName != packageName) return
        }
        Log.e(TAG, "exitFromApp: fail to exit from $packageName")
    }

    /** Tap `Back` button until exit to launcher but not more than [attempts] times */
    fun exitToLauncher(attempts: Int = 5) {
        repeat(attempts) {
            TDevice.uiDevice.pressBack()
            if (TDevice.uiDevice.currentPackageName == TDevice.uiDevice.launcherPackageName) return
        }
        Log.e(TAG, "exitToLauncher: failed to exit to launcher. Current package is ${TDevice.uiDevice.currentPackageName}")
    }
}