package xyz.myachin.yaf.core.os

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import xyz.myachin.yaf.core.os.shell.TShell

object TOs {
    internal val tInstrumentation = InstrumentationRegistry.getInstrumentation()

    /** This context contains data of app under test and not testing app */
    val TTargetContext: Context get() = tInstrumentation.targetContext

    /** Android's package manager */
    val TPackageManager = TTargetContext.packageManager

    /** Remove file or directory [path] */
    fun removeTree(path: String, recursive: Boolean = false) {
        TShell.removeTree(path, recursive)
    }

    /** Move file or directory
     * [source]: from
     * [target]: to
     * [createDir]: create newPath if it not exists
     * */
    fun move(source: String, target: String, createDir: Boolean = false) {
        if (createDir) {
            TShell.createDirectory(target)
        }
        TShell.move(source, target)
    }
}