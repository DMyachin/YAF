package xyz.myachin.yaf.ui.selector.highlevel

import xyz.myachin.yaf.ui.selector.lowlevel.TSelector

/** Приложения. В обёртках неободимо сделать хотя бы пустую реализацию */
abstract class TApplication {
    val android = TSelector("android")

    val gms = TSelector("com.google.android.gms")
    val gPlay = TSelector("com.android.vending")

    val androidSystemUi = TSelector("com.android.systemui")
    val androidPermissionController = TSelector("com.android.permissioncontroller")
    val androidSettings = TSelector("com.android.settings")
}