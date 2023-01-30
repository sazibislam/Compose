package com.sazib.composedemo.ui.theme.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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



    }
  }
}