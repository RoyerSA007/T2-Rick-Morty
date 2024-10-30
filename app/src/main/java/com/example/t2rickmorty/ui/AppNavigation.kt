package com.example.t2rickmorty.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.t2rickmorty.ui.screens.DetailScreen
import com.example.t2rickmorty.ui.screens.ListScreen

@Composable
fun AppNavigatio(){
    val navController : NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "list"){
        composable ("list"){
            ListScreen(onCharacterClick = { character ->
                navController.navigate("detail/${character.id}")
            })
        }

        composable("detail/{characterId}"){ backStackEntry ->
            val characterId = backStackEntry.arguments
                ?.getString("characterId")
                ?.toInt() ?: 0
            DetailScreen(characterId)
        }
    }
}