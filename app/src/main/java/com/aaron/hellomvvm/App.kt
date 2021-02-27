package com.aaron.hellomvvm

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@HiltAndroidApp
class App : Application() {

    companion object {
        lateinit var context: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}