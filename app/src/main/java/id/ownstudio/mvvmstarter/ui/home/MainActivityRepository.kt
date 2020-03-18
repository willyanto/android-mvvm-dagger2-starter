package id.ownstudio.mvvmstarter.ui.home

import id.ownstudio.mvvmstarter.ApiClient
import id.ownstudio.mvvmstarter.model.User
import io.reactivex.Observable
import timber.log.Timber
import javax.inject.Inject

class MainActivityRepository @Inject constructor(private val apiClient: ApiClient) {

    fun getUsersFromApi(): Observable<List<User>> {
        return apiClient.getUsers()
            .doOnNext {
                Timber.d("Dispatching ${it.size} users from API...")
            }
    }
}