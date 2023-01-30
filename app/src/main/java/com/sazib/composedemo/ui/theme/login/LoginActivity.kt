package com.sazib.composedemo.ui.theme.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sazib.composedemo.ui.theme.dashboard.MainActivity
import com.sazib.composedemo.R
import com.sazib.composedemo.ui.theme.White

class LoginActivity : ComponentActivity() {

  private val viewModel = SignUpViewModel()

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
        .verticalScroll(rememberScrollState()),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {

      LogoImage()
      Spacer(modifier = Modifier.height(20.dp))
      Text(text = "Please login")
      Spacer(modifier = Modifier.height(20.dp))

      OutlinedTextField(
        value = viewModel.username,
        onValueChange = { username_ -> viewModel.updateUsername(username_) },
        label = { Text("Email") },
        modifier = Modifier
          .padding(8.dp)
      )

      OutlinedTextField(
        value = viewModel.password,
        onValueChange = { password_ -> viewModel.updatePassword(password_) },
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
          .padding(8.dp)
      )

      Button(
        onClick = {

          startActivity(Intent(this@LoginActivity, MainActivity::class.java))

          // viewModel.login()
        },
        modifier = Modifier
          .padding(8.dp)
      ) {
        Text(text = "Login")
      }
    }
  }

  @Composable
  fun LogoImage() {

    Column(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight(),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {

      Image(
        painterResource(R.drawable.ic_logo),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
          .height(height = Dp(60F))
          .width(width = Dp(60F))
      )
    }
  }
}