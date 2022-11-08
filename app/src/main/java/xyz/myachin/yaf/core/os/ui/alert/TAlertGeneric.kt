package xyz.myachin.yaf.core.os.ui.alert

import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric

/** Типичный алерт. Рекомендуется создавать из [TAlert.createSystemGeneric]
 *
 * [tvTitle] - название алерта
 *
 * [tvMessage] - текст алерта
 *
 * [btPositive] - обычно это кнопка OK. Кнопка, которая прижата обычно к правому нижнему углу
 *
 * [btNegative] - обычно это кнопка отказа. Она находится левее позитивной
 *
 * [btNeutral] - обычно это кнопка отмены. Она прижата к правому нижнему углу
 */
data class TAlertGeneric(
    val tvTitle: TITextGeneric?,
    val tvMessage: TITextGeneric?,
    val btPositive: TIButtonGeneric?,
    val btNegative: TIButtonGeneric?,
    val btNeutral: TIButtonGeneric?,
)