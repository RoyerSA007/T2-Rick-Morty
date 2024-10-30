package com.example.t2rickmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.t2rickmorty.ui.AppNavigatio
import com.example.t2rickmorty.ui.theme.T2RickMortyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            T2RickMortyTheme {
                    AppNavigatio()
                }
            }
        }
    }
