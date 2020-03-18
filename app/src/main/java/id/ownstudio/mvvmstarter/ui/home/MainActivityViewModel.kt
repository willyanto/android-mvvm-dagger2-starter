package id.ownstudio.mvvmstarter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import id.ownstudio.mvvmstarter.base.BaseViewModel
import id.ownstudio.mvvmstarter.model.UsersList
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-15.
 */
class MainActivityViewModel @Inject constructor(repository: MainActivityRepository) :
    BaseViewModel() {

    private val users: MutableLiveData<UsersList> = MutableLiveData()
    private val userLoadError: MutableLiveData<Boolean> = MutableLiveData()
    private val loading: MutableLiveData<Boolean> = MutableLiveData()

    fun getUsers(): LiveData<UsersList> = users
    fun getError(): LiveData<Boolean> = userLoadError
    fun getLoading(): LiveData<Boolean> = loading


    init {
        loading.value = true
        subscribe(
            repository.getUsersFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("Received UIModel $it users.")
                    users.value = UsersList(
                        it,
                        "All Users"
                    )
                }, {
                    Timber.d(it)
                    users.value = UsersList(
                        emptyList(),
                        "An error occurred",
                        it
                    )
                })
        )
    }
}