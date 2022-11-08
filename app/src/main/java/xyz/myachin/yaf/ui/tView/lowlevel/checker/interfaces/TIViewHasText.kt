package xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces

import xyz.myachin.yaf.core.T_SHORT_WAIT

interface TIViewHasText {
    /** Получить текущий текст вью */
    fun text(): String

    /** Утверждение, что текущий текст вью равен [text] или станет таковым через [timeout] */
    fun textIs(text: String, timeout: Long = T_SHORT_WAIT)

    /** Утверждение, что текущий текст вью содержит [text] или станет таковым через [timeout] */
    fun textContains(text: String, timeout: Long = T_SHORT_WAIT)
}