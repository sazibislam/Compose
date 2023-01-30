package com.sazib.composedemo.ui.theme.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

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
}