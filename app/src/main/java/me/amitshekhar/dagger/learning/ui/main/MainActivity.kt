package me.amitshekhar.dagger.learning.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import me.amitshekhar.dagger.learning.MyApplication
import me.amitshekhar.dagger.learning.R
import me.amitshekhar.dagger.learning.di.component.DaggerActivityComponent
import me.amitshekhar.dagger.learning.di.module.ActivityModule
import me.amitshekhar.dagger.learning.ui.home.HomeFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(
            this,
            viewModel.getSomeData(),
            Toast.LENGTH_LONG
        ).show()

        addHomeFragment()
    }

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit()
        }
    }

    private fun getDependencies() {
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()
            .inject(this)
    }

}
