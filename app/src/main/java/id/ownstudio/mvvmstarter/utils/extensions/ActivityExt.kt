package id.ownstudio.mvvmstarter.utils.extensions

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

/**
 * Created by Willyanto Wijaya Sulaiman on 18/03/20.
 */
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).show()

inline fun Activity.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder): AlertDialog {
    return AlertDialog.Builder(this)
        .body()
        .show()
}