package com.aaron.hellomvvm

import android.app.Application
import android.content.Context

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
class App : Application() {

    companion object {
        private lateinit var context: Context

        fun getContext(): Context {
            return context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}