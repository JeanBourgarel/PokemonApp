package fr.ippon.pokemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.ippon.pokemonapp.ui.theme.PokemonAppTheme
import fr.ippon.pokemonapp.views.detail_screen.DetailScreen
import fr.ippon.pokemonapp.views.home_screen.HomeScreen

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PokemonAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
                        composable(route = Screen.MainScreen.route) {
                            HomeScreen(
                                onClickOnPokemon = { pokemonName ->
                                    navController.navigate(Screen.DetailScreen.route + "/${pokemonName}")
                                }
                            )
                        }
                        composable(
                            route = Screen.DetailScreen.route + "/{pokemonName}",
                            arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            DetailScreen(
                                pokemonName = backStackEntry.arguments?.getString("pokemonName"),
                                onClick = { navController.popBackStack()}
                            )
                        }
                    }
                }
            }
        }
    }
}