package com.akkobana.rickandmortyapp.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

object Utils {
    const val SHARED_PREF = "auth-data"
    const val SHARED_PREF_LOGIN = "login"
    const val SHARED_PREF_PASSWORD = "password"
    const val SHARED_PREF_STATE = "state"
    const val BASE_URL_RICK_AND_MORTY = "https://rickandmortyapi.com/api/"
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}