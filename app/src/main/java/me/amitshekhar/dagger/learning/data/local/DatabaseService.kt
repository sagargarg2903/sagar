package me.amitshekhar.dagger.learning.data.local

import android.content.Context

import me.amitshekhar.dagger.learning.di.ApplicationContext
import me.amitshekhar.dagger.learning.di.DatabaseName
import me.amitshekhar.dagger.learning.di.DatabaseVersion

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseService @Inject constructor(
    @ApplicationContext private val context: Context,
    @DatabaseName private val databaseName: String,
    @DatabaseVersion private val version: Int
) {

    fun getDummyData(): String {
        return "DATABASE_DUMMY_DATA"
    }

}
