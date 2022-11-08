package xyz.myachin.yaf.ui.tView.lowlevel.actions.interfaces

interface TIWriteable {
    /** Установить для вью текст [text] */
    fun setText(text: String)

    /** Очистить текст у вью */
    fun clearText()
}