package com.sazib.composedemo.ui.theme.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sazib.composedemo.ui.theme.White

class LoginActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    installSplashScreen()
    super.onCreate(savedInstanceState)
    setContent {
      LoadUi()
    }
  }

  @Preview
  @Composable
  fun LoadUi() {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = White)
        .verticalScroll(rememberScrollState())
    ) {
      var username by remember { mutableStateOf("") }
      var password by rememberSaveable { mutableStateOf("") }

      OutlinedTextField(
        value = username,
        onValueChange = { username = it },
        label = { Text("Email") }
      )

      OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
      )

    }
  }
}