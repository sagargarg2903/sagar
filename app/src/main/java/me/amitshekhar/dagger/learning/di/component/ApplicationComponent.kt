package me.amitshekhar.dagger.learning.di.component

import android.content.Context
import dagger.Component
import me.amitshekhar.dagger.learning.MyApplication
import me.amitshekhar.dagger.learning.data.local.DatabaseService
import me.amitshekhar.dagger.learning.data.local.FileStorageService
import me.amitshekhar.dagger.learning.data.remote.NetworkService
import me.amitshekhar.dagger.learning.di.ApplicationContext
import me.amitshekhar.dagger.learning.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getFileStorageService(): FileStorageService

}
