package id.ownstudio.mvvmstarter.ui.home

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.ownstudio.mvvmstarter.R
import id.ownstudio.mvvmstarter.base.BaseActivity
import id.ownstudio.mvvmstarter.model.UsersList
import id.ownstudio.mvvmstarter.utils.extensions.alertDialog
import id.ownstudio.mvvmstarter.utils.extensions.toast
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.net.ConnectException
import java.net.UnknownHostException


class MainActivity : BaseActivity<MainActivityViewModel>(MainActivityViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getUsers().observe(this, Observer { showUsers(it) })

        viewModel.getError().observe(this, Observer { if (it) showError() })
    }

    private fun showUsers(data: UsersList) {
        if (data.error == null) {
            recycler_view.addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
            recycler_view.adapter = MainAdapter(
                viewModel,
                this,
                data.users
            )
            recycler_view.layoutManager = LinearLayoutManager(this)
        } else if (data.error is ConnectException || data.error is UnknownHostException) {
            Timber.d("No connection, maybe inform user that data loaded from DB.")
        } else {
            showError()
        }
    }

    private fun showError() {
        toast("An error occurred :(")
    }
}