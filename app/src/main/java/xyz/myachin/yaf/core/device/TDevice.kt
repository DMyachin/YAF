package xyz.myachin.yaf.core.device

import android.graphics.Point
import android.os.SystemClock
import android.util.Log
import androidx.test.uiautomator.UiDevice
import xyz.myachin.yaf.core.T_TWO_SECONDS
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.core.os.TOs.tInstrumentation
import java.io.File

/** Working with DEVICE but not OS or apps */
object TDevice {
    private val TAG = TDevice::class.java.simpleName
    private val screenSize get() = Point(uiDevice.displayWidth, uiDevice.displayHeight)

    val uiDevice: UiDevice = UiDevice.getInstance(tInstrumentation)

    fun sleep(timeout: Long = T_TWO_SECONDS) {
        uiDevice.sleep()
        SystemClock.sleep(timeout)
    }

    fun swipeUp(): Boolean {
        val start = Point(screenSize.x / 2, screenSize.y / 5 * 4)
        val end = Point(start.x, start.y / 5)
        return uiDevice.swipe(arrayOf(start, end), 10)
    }

    /** Save screen structure to [fileName] in external cache directory */
    fun dumpScreen(fileName: String): String {
        val out = File(TOs.TTargetContext.externalCacheDir, fileName)
        uiDevice.dumpWindowHierarchy(out)
        Log.i(TAG, "dumpScreen: saved to $out")
        return out.canonicalPath
    }
}