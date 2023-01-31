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
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.sazib.composedemo.R
import com.sazib.composedemo.R.drawable

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
      Spacer(modifier = Modifier.padding(8.dp))

      val textState = remember { mutableStateOf(TextFieldValue("")) }
      SearchView(textState)

    }
  }

  @Composable
  fun SearchView(state: MutableState<TextFieldValue>) {
    TextField(
      value = state.value,
      onValueChange = { value ->
        state.value = value
      },
      modifier = Modifier
        .fillMaxWidth(),
      textStyle = TextStyle(color = Color.White, fontSize = 18.sp),
      leadingIcon = {
        Icon(
          Icons.Default.Search,
          contentDescription = "",
          modifier = Modifier
            .padding(8.dp)
            .size(24.dp)
        )
      },
      trailingIcon = {
        if (state.value != TextFieldValue("")) {
          IconButton(
            onClick = {
              state.value =
                TextFieldValue("")
            }
          ) {

            Icon(
              Icons.Default.Close,
              contentDescription = "",
              modifier = Modifier
                .padding(8.dp)
                .size(24.dp)
            )
          }
        }
      },
      singleLine = true,
      shape = RectangleShape,
      colors = TextFieldDefaults.textFieldColors(
        textColor = Color.White,
        cursorColor = Color.White,
        leadingIconColor = Color.White,
        trailingIconColor = Color.White,
        backgroundColor = Color.White,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
      )
    )
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
        .background(color = Color.Transparent),
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