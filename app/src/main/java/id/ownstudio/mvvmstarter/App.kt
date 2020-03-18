package id.ownstudio.mvvmstarter

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.ownstudio.mvvmstarter.di.component.DaggerAppComponent
import timber.log.Timber

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-15.
 */
class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        Timber.uprootAll()
        Timber.plant(Timber.DebugTree())

        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}