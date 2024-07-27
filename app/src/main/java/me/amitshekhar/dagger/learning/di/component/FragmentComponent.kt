package me.amitshekhar.dagger.learning.di.component

import dagger.Component
import me.amitshekhar.dagger.learning.di.FragmentScope
import me.amitshekhar.dagger.learning.di.module.FragmentModule
import me.amitshekhar.dagger.learning.ui.home.HomeFragment

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)

}
