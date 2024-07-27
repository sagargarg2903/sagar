package me.amitshekhar.dagger.learning

import android.app.Application

import me.amitshekhar.dagger.learning.data.local.DatabaseService
import me.amitshekhar.dagger.learning.data.remote.NetworkService
import me.amitshekhar.dagger.learning.di.component.ApplicationComponent
import me.amitshekhar.dagger.learning.di.component.DaggerApplicationComponent
import me.amitshekhar.dagger.learning.di.module.ApplicationModule

import javax.inject.Inject

class MyApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var databaseService: DatabaseService

    override fun onCreate() {
        super.onCreate()
        getDependencies()
    }

    private fun getDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

}