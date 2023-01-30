package com.sazib.composedemo.ui.theme.login

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.ViewModel
import com.sazib.composedemo.ui.theme.dashboard.MainActivity

class SignUpViewModel : ViewModel() {

  var username by mutableStateOf("")
    private set
  var password by mutableStateOf("")
    private set

  fun updateUsername(input: String) {
    username = input
  }

  fun updatePassword(input: String) {
    password = input
  }

  fun login() {
    Log.d("login button", "Button Clicked")
  }
}