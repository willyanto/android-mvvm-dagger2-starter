package id.ownstudio.mvvmstarter.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import id.ownstudio.mvvmstarter.factory.ViewModelFactory
import id.ownstudio.mvvmstarter.utils.PrefUtil
import javax.inject.Inject

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-15.
 */
abstract class BaseActivity<T : ViewModel>(private val viewModelClass: Class<T>) :
    DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var prefUtil: PrefUtil

    val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(viewModelClass)
    }

}