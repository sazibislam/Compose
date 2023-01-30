package com.sazib.composedemo.ui.theme.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.sazib.composedemo.R
import com.sazib.composedemo.R.drawable
import com.sazib.composedemo.ui.theme.White

class MainActivity : ComponentActivity() {
  private val viewPagerPageCount = 3

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      LoadUi()
    }
  }

  @Preview
  @Composable
  private fun LoadUi() {

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color.White)
    ) {

      TopBar()
      // Spacer(modifier = Modifier.padding(4.dp))
    }
  }

  @OptIn(ExperimentalPagerApi::class)
  @Composable
  private fun TopBar() {
    val slideImage = remember { mutableStateOf(drawable.banner) }
    val state: PagerState = rememberPagerState()

    HorizontalPager(
      count = viewPagerPageCount,
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(color = Color.White)
        .padding(8.dp),
      state = state
    ) { page ->

      when (page) {
        0 -> slideImage.value = drawable.banner
        1 -> slideImage.value = drawable.banner
        2 -> slideImage.value = drawable.banner
      }

      Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clip(
          RoundedCornerShape(15.dp)
        )
      ) {
        Image(
          painterResource(slideImage.value),
          contentDescription = ""
        )
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth()
        .background(color = White),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {

      DotsIndicator(
        selectedIndex = state.currentPage,
        selectedColor = Color(R.color.teal_200),
        unSelectedColor = Color(R.color.black)
      )
    }
  }

  @Composable
  private fun DotsIndicator(
    selectedIndex: Int,
    selectedColor: Color,
    unSelectedColor: Color,
  ) {

    LazyRow(
      modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()
        .background(color = Color.Transparent)
    ) {

      items(viewPagerPageCount) { index ->
        if (index == selectedIndex) {
          Box(
            modifier = Modifier
              .size(10.dp)
              .clip(CircleShape)
              .background(selectedColor)
          )
        } else {
          Box(
            modifier = Modifier
              .size(10.dp)
              .clip(CircleShape)
              .background(unSelectedColor)
          )
        }

        if (index != viewPagerPageCount - 1) {
          Spacer(modifier = Modifier.padding(horizontal = 2.dp))
        }
      }
    }
  }
}