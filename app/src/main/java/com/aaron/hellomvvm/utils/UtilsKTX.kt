package com.aaron.hellomvvm.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import com.aaron.hellomvvm.App

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/26
 */
val Float.dp: Int
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics
    ).toInt()

val Int.color: Int
    get() = ResourcesCompat.getColor(App.getContext().resources, this, null)

private var toast: Toast? = null

fun String.showToast(@ToastDuration duration: Int = Toast.LENGTH_SHORT) {
    toast?.cancel()
    toast = Toast.makeText(App.getContext(), this, duration)
    toast?.show()
}