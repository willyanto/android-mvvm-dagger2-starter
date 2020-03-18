package id.ownstudio.mvvmstarter.di.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.ownstudio.mvvmstarter.ui.home.MainActivityViewModel
import id.ownstudio.mvvmstarter.di.annotation.ViewModelKey

@Module
abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
}