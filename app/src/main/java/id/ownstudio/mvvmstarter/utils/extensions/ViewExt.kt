package id.ownstudio.mvvmstarter.utils.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

/**
 * Created by Willyanto Wijaya Sulaiman on 18/03/20.
 */
fun View.hide() {
    visibility = GONE
}

fun View.show() {
    visibility = VISIBLE
}