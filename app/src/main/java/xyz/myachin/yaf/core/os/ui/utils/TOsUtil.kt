package xyz.myachin.yaf.core.os.ui.utils

import android.content.Context
import xyz.myachin.yaf.core.os.TOs.TAppContext
import xyz.myachin.yaf.core.os.TOs.TTestContext
import xyz.myachin.yaf.core.os.TOs.tDevice

/** Утилитарные вещи, связанные с ОС */
object TOsUtil {
    internal fun getText(context: Context, resId: Int): String {
        return context.getString(resId)
    }

    /** Вернуть текст по ресурсу [resId]. Например: `R.string.some_string` */
    fun getText(resId: Int): String {
        return getText(TAppContext, resId)
    }

    /** Вернуть текст по ресурсу [resId]. Например: `R.string.some_string`.
     *
     * Здесь имеется в виду тот текст, которы таскает с собой сам YAF */
    internal fun getInternalText(resId: Int): String {
        return getText(TTestContext, resId)
    }

    /** Вернуть список строковых ресурсов по [resId] */
    fun getTextArray(resId: Int): Array<String> {
        return TAppContext.resources.getStringArray(resId)
    }

    /** Пакет, находящийся на переднем плане */
    fun getCurrentPkg(): String {
        return tDevice.currentPackageName
    }
}