package com.example.whatsappui

import android.app.Application
import com.example.whatsappui.di.appModule
import com.example.whatsappui.di.dataSourceModule
import com.example.whatsappui.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WhatsAppUI : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@WhatsAppUI)
            modules(listOf(appModule, dataSourceModule, viewModelModule))
        }
    }
}
