package id.ownstudio.mvvmstarter.utils

import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Created by Willyanto Wijaya Sulaiman on 18/03/20.
 */
class PrefUtil @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun putInt(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun putString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun putLong(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun putFloat(key: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun putStringSet(key: String, value: Set<String>) {
        val editor = sharedPreferences.edit()
        editor.putStringSet(key, value)
        editor.apply()
    }

    fun getInt(key: String, def: Int = 0) = sharedPreferences.getInt(key, def)
    fun getString(key: String, def: String = "") = sharedPreferences.getString(key, def)
    fun getBoolean(key: String, def: Boolean = false) = sharedPreferences.getBoolean(key, def)
    fun getLong(key: String, def: Long = 0) = sharedPreferences.getLong(key, def)
    fun getFloat(key: String, def: Float = 0f) = sharedPreferences.getFloat(key, def)
    fun getStringSet(key: String, def: Set<String>) = sharedPreferences.getStringSet(key, def)

    fun remove(key: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        if (sharedPreferences.contains(key)) { // Workaround for pre-HC's lack of StringSets
            val stringSetLength = sharedPreferences.getInt(key, -1)
            if (stringSetLength >= 0) {
                editor.remove(key)
                for (i in 0 until stringSetLength) {
                    editor.remove("$key[$i]")
                }
            }
        }
        editor.remove(key)
        editor.apply()
    }
}
