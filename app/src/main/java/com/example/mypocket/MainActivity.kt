package com.example.mypocket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.mypocket.nav.MyPocketApp
import com.example.mypocket.ui.theme.MyPocketTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyPocketTheme {
                MyPocketApp()
            }
        }
    }
}