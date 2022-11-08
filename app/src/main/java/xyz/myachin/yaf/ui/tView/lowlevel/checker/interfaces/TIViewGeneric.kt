package xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces

import xyz.myachin.yaf.core.T_SHORT_WAIT

interface TIViewGeneric {
    /** Возвращает статус существование вью */
    fun getExistsState(): Boolean

    /** Утверждение, что вью существует или же появится чреез [timeout] */
    fun isExists(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что вью не существует или исчезнет через [timeout]*/
    fun isNotExists(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что вью видима или станет видимой через [timeout] */
    fun isVisible(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что вью невидима или станет невидимой через [timeout] */
    fun isGone(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что вью в статусе `Enabled` или же станет такой через [timeout] */
    fun isEnabled(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что вью в статусе `Disabled` или же станет такой через [timeout] */
    fun isDisabled(timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что `content description` у вью имеет текст [text] или же он станет таковым через [timeout] */
    fun isContentDescription(text: String, timeout: Long = T_SHORT_WAIT)

    /** Возвращает текущий `content description` вью */
    fun contentDesc(): String
}