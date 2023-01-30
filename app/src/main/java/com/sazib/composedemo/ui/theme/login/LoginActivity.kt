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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.sazib.composedemo.R
import com.sazib.composedemo.ui.theme.White
import com.sazib.composedemo.ui.theme.dashboard.MainActivity

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

      var passwordVisible by rememberSaveable { mutableStateOf(false) }

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
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
          .padding(8.dp),
        trailingIcon = {
          val image = if (passwordVisible)
            Icons.Filled.Visibility
          else Icons.Filled.VisibilityOff

          val description = if (passwordVisible) "Hide password" else "Show password"

          IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Icon(imageVector = image, description)
          }
        }
      )

      Button(
        onClick = {
          startActivity(Intent(this@LoginActivity, MainActivity::class.java))
          finish()
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