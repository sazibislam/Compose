package com.sazib.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FilterActivity : ComponentActivity() {
  private val fontHelvetica = FontFamily(Font(R.font.helvetica, FontWeight.Normal))

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
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = Color.White)

    ) {
      LoadToolbar()
      Spacer(modifier = Modifier.height(20.dp))
      TabOne()
      Spacer(modifier = Modifier.height(5.dp))
      TabTwo()
    }
  }

  @Composable
  private fun TabOne() {
    var thumbIconLiked by rememberSaveable { mutableStateOf(true) }

    Row(
      modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color.LightGray)
        .clickable { thumbIconLiked = !thumbIconLiked },
      horizontalArrangement = Arrangement.SpaceBetween
    ) {

      Column(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
      ) {

        Text(
          modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(12.dp),
          text = "Division",
          color = Color.Black,
          fontSize = 16.sp,
          fontFamily = fontHelvetica,
        )
      }

      Column(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
          .padding(8.dp)
      )
      {

        Image(
          painter = painterResource(
            id = if (thumbIconLiked) R.drawable.ic_drop_down_arrow
            else R.drawable.ic_arrow_up
          ),
          contentDescription = "",
          modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(12.dp),
          alignment = Alignment.Center
        )
      }
    }
  }

  @Composable
  private fun TabTwo() {
    var thumbIconLiked by rememberSaveable { mutableStateOf(true) }

    Row(
      modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(RoundedCornerShape(10.dp))
        .background(color = Color.LightGray)
        .clickable { thumbIconLiked = !thumbIconLiked },
      horizontalArrangement = Arrangement.SpaceBetween
    ) {

      Column(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
      ) {

        Text(
          modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(12.dp),
          text = "Zone",
          color = Color.Black,
          fontSize = 16.sp,
          fontFamily = fontHelvetica,
        )
      }

      Column(
        modifier = Modifier
          .wrapContentHeight()
          .wrapContentWidth()
          .padding(8.dp)
      )
      {

        Image(
          painter = painterResource(
            id = if (thumbIconLiked) R.drawable.ic_drop_down_arrow
            else R.drawable.ic_arrow_up
          ),
          contentDescription = "",
          modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(12.dp),
          alignment = Alignment.Center
        )
      }
    }
  }

  @Composable
  private fun LoadToolbar() {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp)
        .height(50.dp)
    ) {

      Spacer(modifier = Modifier.height(20.dp))
      Image(
        painterResource(R.drawable.ic_back_arrow),
        contentDescription = "",
        modifier = Modifier
          .padding(vertical = 15.dp)
          .padding(horizontal = 5.dp)
          .clickable { finish() }
      )

      Text(
        text = "Filter",
        color = Color.Black,
        modifier = Modifier.padding(10.dp),
        fontSize = 20.sp,
        style = TextStyle(
          color = Color.Black,
          fontSize = 16.sp,
          fontFamily = fontHelvetica,
          fontStyle = FontStyle.Normal,
          //textDecoration = TextDecoration.Underline
        )
      )

      Text(
        text = "Clear",
        color = Color(R.color.toolbar_text_color),
        modifier = Modifier
          .padding(8.dp)
          .fillMaxWidth(),
        style = TextStyle(
          color = Color(R.color.toolbar_text_color),
          fontWeight = FontWeight.Bold,
          textAlign = TextAlign.End
        ),
        textAlign = TextAlign.End,
        fontSize = 14.sp
      )
    }
  }
}