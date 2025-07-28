plugins {
    alias(libs.plugins.mapins.android.feature)
    alias(libs.plugins.mapins.android.library.compose)

}

android {
    namespace = "com.example.maps"
}

dependencies {
    implementation(libs.maps.mobile)

}