plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.ex.composeapp"
    compileSdk = 36
    flavorDimensions +="default"
    defaultConfig {
        applicationId = "com.ex.composeapp"
        minSdk = 23
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs{
        create("release") {
            /*storeFile = file("keystore.jks")
            storePassword = "your-store-password"
            keyAlias = "your-key-alias"
            keyPassword = "your-key-password"*/
        }
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    productFlavors {
        create("Dev"){
            dimension = "default"
            buildConfigField("String", "MAN_BASE_URL", "\"https://api.escuelajs.co/api/v1/\"")

        }
        create("Prod"){
            dimension = "default"
            buildConfigField("String", "MAN_BASE_URL", "\"https://api.escuelajs.co/api/v1/\"")

        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        compilerOptions {
            jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
        }
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    //Compose
    implementation(libs.androidx.navigation.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    // Koin
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
    // ViewModel
    implementation(libs.lifecycle.viewmodel.compose)
    //EncPrefs
    implementation(libs.androidx.security.crypto)

}