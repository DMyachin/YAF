package xyz.myachin.yaf.core.device

import android.graphics.Point
import android.os.SystemClock
import android.util.Log
import android.view.KeyEvent
import xyz.myachin.yaf.core.T_SHORT_WAIT
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.core.os.TOs.tDevice
import java.io.File
import kotlin.concurrent.thread


/** Working with DEVICE but not OS or apps */
object TDevice {
    private val TAG = TDevice::class.java.simpleName

    val screenSize: Point by lazy { Point(tDevice.displayWidth, tDevice.displayHeight) }

    fun takeScreenshotAsUser() {
        /*
        я не понимаю почему, но если создать визуальное событие, то скриншот снимается нормально
        Потому сначала дёргается звук, потом снимается скриншот
        Если звук не дёргать, то иногда будет просто гаснуть экран
        Также если дёрнуть звук и затем нажать "Назад", чтобы регулятор громкости исчез, то снова будет гаснуть экран
         */

        pressKeyCode(KeyEvent.KEYCODE_VOLUME_DOWN)

        val t = thread { pressKeyCode(KeyEvent.KEYCODE_POWER) }
        pressKeyCode(KeyEvent.KEYCODE_VOLUME_DOWN)

        t.join()

        SystemClock.sleep(2_000)
        pressDeviceBackButton()
    }

    fun getRawDevice() = tDevice

    fun isScreenOn() = tDevice.isScreenOn

    fun wakeUp() = tDevice.wakeUp()

    fun sleep(timeout: Long = T_SHORT_WAIT) {
        tDevice.sleep()
        SystemClock.sleep(timeout)
    }

    fun setOrientationNatural() = tDevice.setOrientationNatural()

    fun swipeUp() {
        val start = Point(screenSize.x / 2, screenSize.y / 5 * 4)
        val end = Point(start.x, start.y / 5)
        tDevice.swipe(arrayOf(start, end), 10)
    }

    fun pressKeyCode(keyEvent: Int) {
        tDevice.pressKeyCode(keyEvent)
    }

    fun pressDeviceBackButton() {
        tDevice.pressBack()
    }

    /** Сохранить файл [fileName] во внешний кеш приложения. Требуется только имя файла, не полный путь */
    fun dumpScreen(fileName: String): String {
        val out = File(TOs.TAppContext.externalCacheDir, fileName)
        tDevice.dumpWindowHierarchy(out)
        Log.i(TAG, "dumpScreen: saved to $out")
        return out.canonicalPath
    }

    fun pressDeviceHomeButton() {
        tDevice.pressHome()
    }

    fun pressDeviceEnter() {
        tDevice.pressEnter()
    }
}