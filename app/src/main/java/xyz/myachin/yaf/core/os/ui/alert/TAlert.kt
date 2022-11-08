package xyz.myachin.yaf.core.os.ui.alert

import xyz.myachin.yaf.ui.selector.highlevel.TApplicationImpl
import xyz.myachin.yaf.ui.tView.highlevel.TButtonGeneric
import xyz.myachin.yaf.ui.tView.highlevel.TTextGeneric

/** Создание объектов алертов */
object TAlert {
    /** Алерты SystemAlert */
    fun createSystemGeneric(): TAlertGeneric {
        return TAlertGeneric(
            tvTitle = TTextGeneric.fromSelector(TApplicationImpl.android.uiSelectorById("alertTitle")),
            tvMessage = TTextGeneric.fromSelector(TApplicationImpl.android.uiSelectorById("message")),
            btPositive = TButtonGeneric.fromSelector(TApplicationImpl.android.uiSelectorById("button1")),
            btNegative = TButtonGeneric.fromSelector(TApplicationImpl.android.uiSelectorById("button2")),
            btNeutral = TButtonGeneric.fromSelector(TApplicationImpl.android.uiSelectorById("button3")),
        )
    }

    /** Алерт - запрос пермишена */
    fun createPermissionGeneric(): TPermissionGeneric {
        return TPermissionGeneric(
            btAllow = TButtonGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_allow_button")
            ),
            btDeny = TButtonGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_deny_button")
            ),
            btOneTime = TButtonGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_allow_one_time_button")
            ),
            btWhileUsingTheApp = TButtonGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_allow_foreground_only_button")
            ),
            tvTitle = TTextGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_message")
            ),
            btDenyAndDontAskAgain = TButtonGeneric.fromSelector(
                TApplicationImpl.androidPermissionController.uiSelectorById("permission_deny_and_dont_ask_again_button")
            ),
        )
    }
}
