package xyz.myachin.yaf.core.os

import android.content.Context
import android.content.res.Resources
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.R
import xyz.myachin.yaf.core.exceptions.TException
import xyz.myachin.yaf.core.os.shell.TShell
import xyz.myachin.yaf.core.os.ui.notification.TNotification
import xyz.myachin.yaf.core.os.ui.utils.TOsUtil
import xyz.myachin.yaf.ui.tView.highlevel.TButtonGeneric
import xyz.myachin.yaf.ui.tView.highlevel.TTextGeneric

/** Получить от ОС какую-то информацию или же выставить настройки */
object TOs {
    private val tInstrumentation = InstrumentationRegistry.getInstrumentation()
    internal val tDevice: UiDevice = UiDevice.getInstance(tInstrumentation)

    /** This is context contains data of wrapper. It's preferred choice */
    internal val TAppContext: Context get() = tInstrumentation.targetContext

    /** This is context contains data of this application. I.e. it is context not app's but of test */
    internal val TTestContext: Context get() = tInstrumentation.context

    private const val notificationId = "android:id/status_bar_latest_event_content"

    /** Получить PackageManager */
    val TPackageManager = TAppContext.packageManager

    /** Управление и запрос статуса автоматического управления временем в системе */
    var autoTime: Boolean
        get() = TShell.autoTime
        set(value) {
            TShell.autoTime = value
        }

    /** Установить текущее время на устройстве. Не будет работать, если не выключена синхронизация по сети
     * ```
     * Некоторые поддерживаемые форматы (подробнее см `adb shell date --help`):
     * YYYY-MM-DD [hh:mm[:ss]]   ISO 8601
     * hh:mm[:ss]                24-hour time today
     * ```
     * @see autoTime
     */
    fun setDateTime(dateTime: String) {
        TShell.setDate(dateTime)
        TShell.sendTimeSetBroadcast()
    }

    /** Удалить файл или папку по пути [path] */
    fun removeTree(path: String, recursive: Boolean = false) {
        TShell.removeTree(path, recursive)
    }

    /** Переименовать файл [oldName] в [newName] */
    fun renameFile(oldName: String, newName: String) {
        TShell.renameFile(oldName, newName)
    }

    /** Опущена ли панель уведомлений */
    fun isNotificationsOpened(): Boolean {
        return tDevice.findObject(UiSelector().resourceId(notificationId)).exists()
    }

    /** Получить список всех видимых [xyz.myachin.yaf.core.os.ui.notification.TNotification] */
    val actualNotifications: ArrayList<TNotification>
        get() {
            val notifications =
                tDevice.findObjects(By.res(notificationId))
            val result = ArrayList<TNotification>(notifications.size)

            notifications.forEach { notification ->
                val button = try {
                    TButtonGeneric.fromObject(notification.findObject(By.res("android:id/expand_button")))
                } catch (_: NullPointerException) {
                    null
                }

                result.add(
                    TNotification(
                        tvAppName = try {
                            TTextGeneric.fromObject(notification.findObject(By.res("android:id/app_name_text")))
                        } catch (_: NullPointerException) {
                            null
                        },

                        tvTitle = TTextGeneric.fromObject(notification.findObject(By.res("android:id/title"))),

                        tvBigText = try {
                            TTextGeneric.fromObject(notification.findObject(By.res("android:id/big_text")))
                        } catch (_: NullPointerException) {
                            null
                        },

                        tvText = try {
                            TTextGeneric.fromObject(notification.findObject(By.res("android:id/text")))
                        } catch (_: NullPointerException) {
                            null
                        },

                        expandButton = button,

                        isExpanded = try {
                            if (button == null) {
                                null
                            } else {
                                try {
                                    button.isContentDescription(TOsUtil.getInternalText(R.string.collapse))
                                    true
                                } catch (_: Resources.NotFoundException) {
                                    button.isContentDescription(TOsUtil.getText(R.string.collapse))
                                    true
                                }
                            }
                        } catch (_: TException) {
                            try {
                                button?.isContentDescription(TOsUtil.getInternalText(R.string.expand))
                                false
                            } catch (_: Resources.NotFoundException) {
                                button?.isContentDescription(TOsUtil.getText(R.string.expand))
                                false
                            }
                        },

                        btAction0 = try {
                            TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action0")))
                        } catch (_: NullPointerException) {
                            null
                        },

                        btAction1 = try {
                            TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action1")))
                        } catch (_: NullPointerException) {
                            null
                        },

                        btAction2 = try {
                            TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action2")))
                        } catch (_: NullPointerException) {
                            null
                        },
                    )
                )
            }
            return result
        }

    /** Получить список всех видимых [xyz.myachin.yaf.core.os.ui.notification.TNotification] */
    private fun getAllNotifications(context: Context): ArrayList<TNotification> {
        val notifications =
            tDevice.findObjects(By.res(notificationId))
        val result = ArrayList<TNotification>(notifications.size)

        notifications.forEach { notification ->
            val button = try {
                TButtonGeneric.fromObject(notification.findObject(By.res("android:id/expand_button")))
            } catch (_: NullPointerException) {
                null
            }

            result.add(
                TNotification(
                    tvAppName = try {
                        TTextGeneric.fromObject(notification.findObject(By.res("android:id/app_name_text")))
                    } catch (_: NullPointerException) {
                        null
                    },

                    tvTitle = TTextGeneric.fromObject(notification.findObject(By.res("android:id/title"))),

                    tvBigText = try {
                        TTextGeneric.fromObject(notification.findObject(By.res("android:id/big_text")))
                    } catch (_: NullPointerException) {
                        null
                    },

                    tvText = try {
                        TTextGeneric.fromObject(notification.findObject(By.res("android:id/text")))
                    } catch (_: NullPointerException) {
                        null
                    },

                    expandButton = button,

                    isExpanded = try {
                        if (button == null) {
                            null
                        } else {
                            button.isContentDescription(TOsUtil.getText(context, R.string.collapse))
                            true
                        }
                    } catch (_: TException) {
                        button?.isContentDescription(TOsUtil.getText(context, R.string.expand))
                        false
                    },

                    btAction0 = try {
                        TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action0")))
                    } catch (_: NullPointerException) {
                        null
                    },

                    btAction1 = try {
                        TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action1")))
                    } catch (_: NullPointerException) {
                        null
                    },

                    btAction2 = try {
                        TButtonGeneric.fromObject(notification.findObject(By.res("android:id/action2")))
                    } catch (_: NullPointerException) {
                        null
                    },
                )
            )
        }
        return result
    }

    fun getProcesses(processFilter: String): List<String> {
        return TShell.getProcessesArgs().split('\n').filter { it.contains(processFilter) }
    }
}