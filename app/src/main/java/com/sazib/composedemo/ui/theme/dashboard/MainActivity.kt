package com.sazib.composedemo.ui.theme.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.sazib.composedemo.R.drawable

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LoadUi()
    }
  }

  @OptIn(ExperimentalPagerApi::class)
  @Preview
  @Composable
  fun LoadUi() {

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.White)
        .padding(8.dp),
    ) {
      val slideImage = remember { mutableStateOf(drawable.banner) }
      HorizontalPager(
        count = 3,
        modifier = Modifier
          .fillMaxWidth()
          .wrapContentHeight()
          .background(color = Color.White)
      ) { page ->

        when (page) {
          0 -> slideImage.value = drawable.banner
          1 -> slideImage.value = drawable.banner
          2 -> slideImage.value = drawable.banner
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Image(
            painterResource(slideImage.value),
            contentDescription = ""
          )
        }
      }
      Spacer(modifier = Modifier.padding(4.dp))

    }
  }
}