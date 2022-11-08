package xyz.myachin.yaf.core.os.ui.alert

import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric


/** Типовой запрос разрешений. Рекомендуется создавать из [TAlert.createPermissionGeneric]
 *
 * [tvTitle] - название запроса разрешений
 *
 * [btAllow] - предоставить разрешение
 *
 * [btOneTime] - предоставить разрешение на текущий запуск. Кнопка есть не всегда
 *
 * [btDeny] - не предоставлять разрешение
 *
 * [btWhileUsingTheApp] - предоставить разрешение на время работы приложения. Кнопка есть не всегда
 *
 * [btDenyAndDontAskAgain] - запретить выдачу разрешения и больше не спрашивать. В некоторых случаях заменяет кнопку btDeny
 */
data class TPermissionGeneric(
    val tvTitle: TITextGeneric,
    val btDeny: TIButtonGeneric,
    val btOneTime: TIButtonGeneric?,
    val btAllow: TIButtonGeneric,
    val btWhileUsingTheApp: TIButtonGeneric?,
    val btDenyAndDontAskAgain: TIButtonGeneric?,
)
