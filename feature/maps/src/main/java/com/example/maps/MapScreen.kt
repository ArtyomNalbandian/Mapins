package com.example.maps

@Composable
fun YandexMapScreen() {
    val context = LocalContext.current
    val mapView = remember {
        MapView(context).apply {
            MapKitFactory.initialize(context)
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
