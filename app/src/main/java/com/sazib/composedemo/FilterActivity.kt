package com.sazib.composedemo

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class FilterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadUi()
        }
    }


    @Preview
    @Composable
    fun LoadUi() {

        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(R.color.white))

        ) {
            LoadToolbar()
            Spacer(modifier = Modifier.height(20.dp))
            Tabone()
            Spacer(modifier = Modifier.height(5.dp))
            Tabtwo()
        }

    }

    @Composable
    fun Tabone(){
        var thumbIconLIked by rememberSaveable { mutableStateOf(true) }

        Row(modifier = Modifier
            .padding(5.dp)
            .padding(horizontal = 5.dp)
            .background(
                color = Color(R.color.tab_color),
                shape = RoundedCornerShape(10.dp)
            )
            .wrapContentHeight()
            .clickable {         thumbIconLIked = !thumbIconLIked }
        ) {
            val FontHelvetica = FontFamily(
                Font(R.font.helvetica, FontWeight.Normal)
            )

            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .padding(horizontal = 10.dp),
                text = "Division    ",
                color = Color(R.color.black),
                fontSize = 20.sp,
                style = TextStyle(
                    color = Color(R.color.black),
                    fontSize = 16.sp,
                    fontFamily = FontHelvetica,
                    fontStyle = FontStyle.Normal,
                    //textDecoration = TextDecoration.Underline
                )
            )

            Image(
                painter = painterResource(
                    id = if (thumbIconLIked) {
                        R.drawable.ic_drop_down_arrow
                    } else {
                        R.drawable.ic_arrow_up
                    }),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                    .padding(horizontal = 15.dp)
                    .clickable { Modifier.rotate(180F) }
                ,
                Alignment.CenterEnd

            )
        }
    }

    @Composable
    fun Tabtwo(){
        var thumbIconLIked by rememberSaveable { mutableStateOf(true) }

        Row(modifier = Modifier
            .padding(5.dp)
            .padding(horizontal = 5.dp)
            .background(color = Color(R.color.tab_color), shape = RoundedCornerShape(10.dp))
            .wrapContentHeight()
            .clickable {         thumbIconLIked = !thumbIconLIked }
        ) {

            val FontHelvetica = FontFamily(
                Font(R.font.helvetica, FontWeight.Normal)
            )

            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .padding(horizontal = 10.dp),
                text = "Zone",
                color = Color(R.color.black),
                fontSize = 20.sp,
                fontFamily = FontHelvetica
            )

            Image(
                painter = painterResource(
                    id = if (thumbIconLIked) {
                        R.drawable.ic_drop_down_arrow
                    } else {
                        R.drawable.ic_arrow_up
                    }),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
                    .padding(horizontal = 15.dp)
                    .clickable { Modifier.rotate(180F) }
                ,
                Alignment.CenterEnd

            )
        }
    }
    @Composable
    fun LoadToolbar(){
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(50.dp)) {

            Spacer(modifier = Modifier.height(20.dp))
            Image(
                painterResource(R.drawable.ic_back_arrow),
                contentDescription = "",
                modifier = Modifier
                    .padding(vertical = 15.dp)
                    .padding(horizontal = 5.dp)
                    .clickable { finish() }

            )
            val FontHelvetica = FontFamily(
                Font(R.font.helvetica, FontWeight.Normal)
            )

            Text(
                text = "Filter",
                color = Color(R.color.black),
                modifier = Modifier.padding(10.dp),
                fontSize = 20.sp,
                fontFamily = FontHelvetica,
                style = TextStyle(
                    color = Color(R.color.black),
                    fontSize = 16.sp,
                    fontFamily = FontHelvetica,
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Normal,
                    //textDecoration = TextDecoration.Underline
                )

            )

            Text(
                text = "Clear",
                color = Color(R.color.toolbar_text_color),
                modifier = Modifier
                    .padding(5.dp)
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                ,
                style = TextStyle(
                    color = Color(R.color.toolbar_text_color),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End
                ),
                textAlign = TextAlign.End,
                fontSize = 13.sp
            )

        }
    }

    }




