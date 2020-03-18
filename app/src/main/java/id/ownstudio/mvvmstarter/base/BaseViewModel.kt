package id.ownstudio.mvvmstarter.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-15.
 */
open class BaseViewModel : ViewModel() {

    private val subscriptions = CompositeDisposable()

    fun subscribe(disposable: Disposable): Disposable {
        subscriptions.add(disposable)
        return disposable
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }

}