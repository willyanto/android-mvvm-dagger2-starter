package id.ownstudio.mvvmstarter.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import id.ownstudio.mvvmstarter.App
import id.ownstudio.mvvmstarter.BuildConfig
import id.ownstudio.mvvmstarter.utils.PrefUtil
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            Context.MODE_PRIVATE
        )

    @Provides
    @Singleton
    fun providePrefUtil(sharedPreferences: SharedPreferences): PrefUtil =
        PrefUtil(sharedPreferences)

}