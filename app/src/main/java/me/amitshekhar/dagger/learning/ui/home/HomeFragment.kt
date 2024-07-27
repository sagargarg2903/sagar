package me.amitshekhar.dagger.learning.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import me.amitshekhar.dagger.learning.MyApplication
import me.amitshekhar.dagger.learning.R
import me.amitshekhar.dagger.learning.di.component.DaggerFragmentComponent
import me.amitshekhar.dagger.learning.di.module.FragmentModule
import javax.inject.Inject

class HomeFragment : Fragment() {

    companion object {

        const val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        getDependencies()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tvMessage = view.findViewById<TextView>(R.id.tv_message)
        tvMessage.text = viewModel.getSomeData()
    }

    private// to suppress null pointer exception warning
    fun getDependencies() {
        DaggerFragmentComponent
            .builder()
            .applicationComponent((requireContext().applicationContext as MyApplication).applicationComponent)
            .fragmentModule(FragmentModule(this)) // this is shown as deprecated as no instance provided by it is being injected
            .build()
            .inject(this)
    }

}
