package com.example.mapins

import android.app.Application
import com.example.maps.YandexMapInitializer

class MapinsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        YandexMapInitializer.init(this, BuildConfig.YANDEX_MAPS_API_KEY)
    }
}
