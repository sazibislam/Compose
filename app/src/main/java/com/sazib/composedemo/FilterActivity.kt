package com.sazib.composedemo

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class FilterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoadUi()
        }
    }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Preview
    @Composable
    fun LoadUi() {
            Scaffold(
                topBar = {
                    TopAppBar(
                        backgroundColor = Color(R.color.ac_bg_color),
                        title = {
                            Text(text="Filter", color = Color(R.color.black))
                        },

                        navigationIcon = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.ArrowBack, contentDescription = "menu")
                            }
                        }, contentColor = Color(R.color.purple_200),
                        actions = {
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Notifications, contentDescription = "noti")
                            }
                            IconButton(onClick = { }) {
                                Icon(Icons.Filled.Search, contentDescription = "search")
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.Add, contentDescription = "add")
                        }
                    }
                },
                // floatingActionButtonPosition = FabPosition.End
            ){
                ShowSwitch()
            }
        }
    }


@Composable
fun ShowSwitch() {

    val isChecked = remember {
        mutableStateOf(true)
    }

    Switch(
        checked = isChecked.value,
        onCheckedChange = {
            isChecked.value = it
        },
        modifier = Modifier.run {
            size(20.dp)
            padding(100.dp)
        }
    )

}

