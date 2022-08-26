package fr.ippon.pokemonapp.views.main_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.ippon.pokemonapp.viewmodels.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen(viewModel: HomeViewModel = getViewModel(), modifier: Modifier = Modifier) {
    Column {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(viewModel.pokemonList) { index, pokemon ->
                if (index == viewModel.pokemonList.lastIndex) {
                    viewModel.getPokemons()
                }
                PokemonCard(pokemon)
            }
        }
    }
}