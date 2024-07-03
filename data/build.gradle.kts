import java.util.Properties

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "benhamida.jassem.data"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val keystoreFile = project.rootProject.file("local.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())
        buildConfigField("String", "TMDB_TOKEN", properties.getProperty("tmdb_token"))
        buildConfigField("String", "ACCOUNT_ID", properties.getProperty("account_id"))
        buildConfigField("String", "API_KEY", properties.getProperty("api_key"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.paging)
    implementation(libs.retrofit)
    implementation(libs.http.logging.interceptor)
    implementation(libs.moshi)
    implementation(libs.moshi.retrofit.converter)
    ksp(libs.moshi.codegen)
    implementation(libs.gson)

    testImplementation(libs.junit)
    testImplementation(libs.mockk.test)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.androidx.arch.testing)
    testImplementation(libs.turbine.testing)
    testImplementation(libs.assertj)
    testImplementation(libs.androidx.paging.testing)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}