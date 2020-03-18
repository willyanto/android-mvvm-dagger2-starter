package id.ownstudio.mvvmstarter.di.module


import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.ownstudio.mvvmstarter.ui.home.MainActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributesInjectMainActivity(): MainActivity

    // more activity injection

//    @ContributesAndroidInjector(modules = OnBoardingActivityModule::class)
//            abstract  fun contributeOnboardingActivity(): OnBoardingActivity
//
//    @ContributesAndroidInjector(modules = LoginActivityModule::class)
//            abstract fun contributeLoginActivity(): LoginActivity
//
//    @ContributesAndroidInjector(modules = {
//        MainActivityModule::class,
//        CategoryFragmentProvider::class,
//        ProfileFragmentProvider::class,
//        LeaderboardFragmentProvider::class})
//    abstract fun contributeMainActivity(): MainActivity
//
//    @ContributesAndroidInjector(modules = {
//        StagesFragmentProvider::class,
//        QuestionFragmentProvider::class})
//    abstract fun contributeStageActivity(): StageActivity
}