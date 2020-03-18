package id.ownstudio.mvvmstarter.model

data class UsersList(val users: List<User>, val message: String, val error: Throwable? = null)