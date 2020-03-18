package id.ownstudio.mvvmstarter

import id.ownstudio.mvvmstarter.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiClient {

    @GET("users")
    fun getUsers(): Observable<List<User>>
}