package com.pathok.user.android

import android.app.Application
import com.pathok.user.di.initKoin


/**
 * Created by Shuvo on 07/07/2025.
 */
class PathokAndroidApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}