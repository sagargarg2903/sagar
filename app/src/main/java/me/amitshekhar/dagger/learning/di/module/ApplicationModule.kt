package me.amitshekhar.dagger.learning.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import me.amitshekhar.dagger.learning.MyApplication
import me.amitshekhar.dagger.learning.data.local.FileStorageService
import me.amitshekhar.dagger.learning.data.remote.HttpClient
import me.amitshekhar.dagger.learning.di.ApplicationContext
import me.amitshekhar.dagger.learning.di.DatabaseName
import me.amitshekhar.dagger.learning.di.DatabaseVersion
import me.amitshekhar.dagger.learning.di.NetworkApiKey
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context {
        return application
    }

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return HttpClient()
    }

    @Provides
    @DatabaseName
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseVersion
    fun provideDatabaseVersion(): Int = 1

    @Provides
    @NetworkApiKey
    fun provideApiKey(): String = "SOME_API_KEY"

    @Singleton
    @Provides
    fun provideFileStorageService(): FileStorageService {
        return FileStorageService()
    }

}
