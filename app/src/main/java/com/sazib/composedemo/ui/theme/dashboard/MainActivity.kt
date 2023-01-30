package com.sazib.composedemo.ui.theme.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sazib.composedemo.R.drawable

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
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
        .background(color = Color(0xFFF2F2F2))
        .verticalScroll(rememberScrollState())
    ) {

      Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = painterResource(drawable.banner),
        contentDescription = "Content description for visually impaired"
      )

      Column(modifier = Modifier.padding(16.dp)) {
        Text(
          text = "Happy Meal",
          style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
          text = "800 calories",
          style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
          text = "$5.99",
          style = MaterialTheme.typography.body1,
          fontSize = 30.sp
        )
      }
    }
  }
}