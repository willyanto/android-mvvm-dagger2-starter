package id.ownstudio.mvvmstarter.utils.extensions

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

/**
 * Created by Willyanto Wijaya Sulaiman on 18/03/20.
 */
fun Fragment.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    activity?.toast(message, duration)

inline fun Fragment.alertDialog(body: AlertDialog.Builder.() -> AlertDialog.Builder) =
    activity?.alertDialog(body)
