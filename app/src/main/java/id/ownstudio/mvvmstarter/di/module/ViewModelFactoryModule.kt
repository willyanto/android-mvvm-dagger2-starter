package id.ownstudio.mvvmstarter.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import id.ownstudio.mvvmstarter.factory.ViewModelFactory
import javax.inject.Provider
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {

    @Provides
    @Singleton
    fun viewModelFactory(providerMap: Map<Class<out ViewModel>, Provider<ViewModel>>): ViewModelProvider.Factory {
        return ViewModelFactory(providerMap)
    }
}