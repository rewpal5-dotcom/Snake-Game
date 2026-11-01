// App module build configuration
plugins {
    id("com.android.application")
}

android {
    namespace = "com.snakegame.app"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.snakegame.app"
        minSdk = 24
        targetSdk = 35
        versionCode = 2
        versionName = "0.2"
    }

    buildTypes {
        debug { isMinifyEnabled = false }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
