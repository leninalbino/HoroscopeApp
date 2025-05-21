plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.android.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.android.safeargs)
}

android {
    namespace = "com.dev.horoscapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.dev.horoscapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            // Set name application for release build
            resValue("string", "devCodeName", "HoroscApp")
            // Set the base URL for the release build
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            // Set name application for debug build
            resValue("string", "devCodeName", "[DEBUG] HoroscApp")
            // Set the base URL for the debug build
            // In this case, we are using a different base URL for the debug build
            // You can change this URL to point to your debug server or API
            // For example:
            // buildConfigField("String", "BASE_URL", "\"https://debug-server.example.com/\"")
            // Or use a local server:
            // buildConfigField("String", "BASE_URL", "\"http://
            buildConfigField("String", "BASE_URL", "\"https://newastro-debug.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

}

dependencies {

    // NavComponent
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.javapoet)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Interceptor
    implementation(libs.logging.interceptor)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}