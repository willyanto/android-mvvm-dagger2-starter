package id.ownstudio.mvvmstarter.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import id.ownstudio.mvvmstarter.R
import id.ownstudio.mvvmstarter.model.User
import kotlinx.android.synthetic.main.item_listview.view.*
import timber.log.Timber

/**
 * Created by Willyanto Wijaya Sulaiman on 2020-03-17.
 */
class MainAdapter(
    viewModel: MainActivityViewModel,
    lifecycleOwner: LifecycleOwner,
    val usersList: List<User>
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    /* If get data from ViewModel */
//    private var usersList: MutableList<User> = ArrayList()

//    init {
//        viewModel.getUsers().observe(lifecycleOwner, Observer { user ->
//            usersList.clear()
//            if (user != null) {
//                usersList.addAll(user.users)
//                notifyDataSetChanged();
//            }
//        })
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_listview, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindPhoto(usersList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var view: View = itemView
        private var user: User? = null

        init {
            view.setOnClickListener {
                Timber.d("Click item ${user!!.login}")
            }
        }

        fun bindPhoto(user: User) {
            this.user = user
            view.tv_1.text = user.login
            view.tv_2.text = user.avatar_url
            view.tv_3.text = user.repos_url
        }
    }
}