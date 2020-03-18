package id.ownstudio.mvvmstarter.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import id.ownstudio.mvvmstarter.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-15.
 */
class BaseFragment<T : ViewModel>(private val viewModelClass: Class<T>) : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }
}