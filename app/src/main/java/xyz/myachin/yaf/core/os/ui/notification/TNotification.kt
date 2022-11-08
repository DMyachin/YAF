package xyz.myachin.yaf.core.os.ui.notification

import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TIButtonGeneric
import xyz.myachin.yaf.ui.tView.highlevel.interfaces.TITextGeneric

/** Представление каждой отдельной нотификации.
 * Полный список можно получить из [xyz.myachin.yaf.core.os.TOs.actualNotificationsForUiAutomator] или [xyz.myachin.yaf.core.os.TOs.actualNotificationsForEspresso]
 *
 * [tvAppName] - название приложение. Его может не быть, если нотификация свёрнута
 *
 * [tvTitle] - название нотификации
 *
 * [tvBigText] - текст нотификации под заголовком
 *
 * [tvText] - текст нотификации
 *
 * [expandButton] - кнопка сворачивания/разворачивания нотификации
 *
 * [isExpanded] - свёрнута ли нотификация
 *
 * [btAction0] - возможная кнока действий 1
 *
 * [btAction1] - возможная кнока действий 2
 *
 * [btAction2] - возможная кнока действий 3
 */
data class TNotification(
    val tvAppName: TITextGeneric?,
    val tvTitle: TITextGeneric,
    val tvText: TITextGeneric?,
    val tvBigText: TITextGeneric?,
    val expandButton: TIButtonGeneric?,
    val isExpanded: Boolean?,
    val btAction0: TIButtonGeneric?,
    val btAction1: TIButtonGeneric?,
    val btAction2: TIButtonGeneric?,
)