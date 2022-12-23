package xyz.myachin.yaf.ui.tView.lowlevel.checker.interfaces

import xyz.myachin.yaf.core.T_TEN_SECONDS

interface TIViewHasCompoundButton {
    /** Утверждение, что вью в состоянии `checked` или же станет таким через [timeout] */
    fun isChecked(timeout: Long = T_TEN_SECONDS)

    /** Утверждение, что вью в состоянии `unchecked` или же станет таким через [timeout] */
    fun isUnchecked(timeout: Long = T_TEN_SECONDS)

    /** Выяснить, `checked` ли сейчас вью */
    fun getCheckState(): Boolean
}