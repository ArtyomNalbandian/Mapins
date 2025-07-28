package com.example.maps

import android.app.Application
import com.yandex.mapkit.MapKitFactory

object YandexMapInitializer {
    fun init(application: Application, apiKey: String) {
        MapKitFactory.setApiKey(apiKey)
        MapKitFactory.initialize(application)
    }
}
