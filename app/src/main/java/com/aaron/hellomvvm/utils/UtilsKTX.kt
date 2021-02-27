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
    get() = ResourcesCompat.getColor(App.context.resources, this, null)

private var toast: Toast? = null

enum class ToastDuration(val toastDuration: Int) {
    SHORT(Toast.LENGTH_SHORT),
    LONG(Toast.LENGTH_LONG)
}

fun String.showToast(duration: ToastDuration = ToastDuration.SHORT) {
    toast?.cancel()
    toast = Toast.makeText(App.context, this, duration.toastDuration)
    toast?.show()
}