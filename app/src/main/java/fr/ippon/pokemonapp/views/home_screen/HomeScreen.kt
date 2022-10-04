package fr.ippon.pokemonapp.views.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import fr.ippon.pokemonapp.viewmodels.DetailScreenState
import fr.ippon.pokemonapp.viewmodels.HomeScreenState
import fr.ippon.pokemonapp.viewmodels.HomeViewModel
import fr.ippon.pokemonapp.views.detail_screen.PokemonDetail
import fr.ippon.pokemonapp.views.util.ErrorScreen
import fr.ippon.pokemonapp.views.util.Loader
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel(), onClickOnPokemon: (String) -> Unit) {
    when(val state = viewModel.homeScreenState) {
        is HomeScreenState.Data -> {
            Column {
                PokemonList(
                    pokemonList = state.data,
                    onScrollToEnd = { viewModel.getPokemons() },
                    onClickOnPokemon = { pokemonName ->
                        onClickOnPokemon(pokemonName)
                    }
                )
            }
        }
        is HomeScreenState.Error -> {
            ErrorScreen(onClick = {
                viewModel.getPokemons()
            })
        }
        is HomeScreenState.Loading -> {
            Loader()
        }
    }
}