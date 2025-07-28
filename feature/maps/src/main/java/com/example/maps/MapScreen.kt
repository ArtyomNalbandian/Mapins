package com.example.maps

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView

@Composable
fun YandexMapScreen(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
//            MapKitFactory.initialize(context)
            map.move(
                CameraPosition(Point(55.751244, 37.618423), 14.0f, 0.0f, 0.0f),
                Animation(Animation.Type.SMOOTH, 1.5f),
                null
            )
        }
    }

    AndroidView(factory = { mapView })

    DisposableEffect(Unit) {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        onDispose {
            mapView.onStop()
            MapKitFactory.getInstance().onStop()
        }
    }
}
