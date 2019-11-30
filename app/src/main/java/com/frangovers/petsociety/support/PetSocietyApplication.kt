package com.frangovers.petsociety.support

import android.app.Application
import android.content.Context
import io.realm.Realm
import io.realm.RealmConfiguration

class PetSocietyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        // Initialize Crashlytics
        // Crashlytics should only be run in the production builds
//        if (!BuildConfig.DEBUG) {
//            Fabric.with(this, Crashlytics())
//        }

        // Configure Realm - Delete Realm content if Migration is needed
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("frangovers.petsociety.realm")
            .schemaVersion(0L)
            .migration(VizstatsRealmMigrations())
            .build()
        Realm.setDefaultConfiguration(config)

        //Initialize Fscebook SDK
        //FacebookSdk.sdkInitialize(applicationContext)
    }

    companion object {

        private lateinit var instance: Application
        val context: Context
            get() {
                return instance.applicationContext
            }
    }
}