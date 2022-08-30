package fr.ippon.pokemonapp.views.main_page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import fr.ippon.pokemonapp.viewmodels.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(viewModel: HomeViewModel = getViewModel()) {
    Column {
        PokemonList(
            pokemonList = viewModel.pokemonList,
            onScrollToEnd = { viewModel.getPokemons() }
        )
    }
}