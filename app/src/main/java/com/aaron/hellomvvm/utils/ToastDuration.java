package com.aaron.hellomvvm.utils;

import android.widget.Toast;

import androidx.annotation.IntDef;

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/27
 */
@IntDef({
        Toast.LENGTH_SHORT,
        Toast.LENGTH_LONG
})
public @interface ToastDuration {
}
