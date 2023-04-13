package com.example.whatsappui.util

import android.content.res.Resources

object Util {

    fun dpToPx(dp: Int): Int {
        return (dp * Resources.getSystem().displayMetrics.density).toInt()
    }
}
