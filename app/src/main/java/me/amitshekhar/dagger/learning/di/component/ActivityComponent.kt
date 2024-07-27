package me.amitshekhar.dagger.learning.di.component

import dagger.Component
import me.amitshekhar.dagger.learning.di.ActivityScope
import me.amitshekhar.dagger.learning.di.module.ActivityModule
import me.amitshekhar.dagger.learning.ui.main.MainActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)

}
