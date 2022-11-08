package xyz.myachin.yaf.ui.selector.lowlevel

import androidx.test.uiautomator.By
import androidx.test.uiautomator.BySelector
import androidx.test.uiautomator.UiSelector
import xyz.myachin.yaf.core.os.TOs
import xyz.myachin.yaf.core.os.ui.utils.TOsUtil

class TSelector(val appPackage: String) {
    fun uiSelectorById(id: String): UiSelector {
        return UiSelector().resourceId("$appPackage:id/$id")
    }

    fun bySelectorById(id: String): BySelector {
        return By.res("$appPackage:id/$id")
    }

    /** Не рекомендуется к использованию. Лучше передавать `R.string.name` */
    fun uiSelectorByContentDescription(description: String): UiSelector {
        return UiSelector().descriptionContains(description)
    }

    /** Не рекомендуется к использованию. Лучше передавать `R.string.name` */
    fun bySelectorByContentDescription(description: String): BySelector {
        return By.descContains(description)
    }

    fun uiSelectorByContentDescription(description: Int): UiSelector {
        return UiSelector().descriptionContains(TOsUtil.getText(TOs.TAppContext, description))
    }

    fun bySelectorByContentDescription(description: Int): BySelector {
        return By.descContains(TOsUtil.getText(TOs.TAppContext, description))
    }

    /** Не рекомендуется к использованию. Лучше передавать `R.string.name` */
    fun uiSelectorByText(text: String): UiSelector {
        return UiSelector().text(text)
    }

    /** Не рекомендуется к использованию. Лучше передавать `R.string.name` */
    fun bySelectorByText(text: String): BySelector {
        return By.text(text)
    }

    fun uiSelectorByText(text: Int): UiSelector {
        return UiSelector().text(TOsUtil.getText(TOs.TAppContext, text))
    }

    fun bySelectorByText(text: Int): BySelector {
        return By.text(TOsUtil.getText(TOs.TAppContext, text))
    }
}