package id.ownstudio.mvvmstarter.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import id.ownstudio.mvvmstarter.App
import id.ownstudio.mvvmstarter.di.module.*
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class, AppModule::class, ApiModule::class, ActivityBuilderModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

}