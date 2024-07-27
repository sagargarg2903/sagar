package me.amitshekhar.dagger.learning.ui.main

import me.amitshekhar.dagger.learning.data.local.DatabaseService
import me.amitshekhar.dagger.learning.data.remote.NetworkService
import me.amitshekhar.dagger.learning.di.ActivityScope

import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(
    private val databaseService: DatabaseService,
    private val networkService: NetworkService
) {

    fun getSomeData(): String {
        return "dsHashCode: " + databaseService.hashCode() + "\n" + "nsHashCode: " + networkService.hashCode()
    }

}
