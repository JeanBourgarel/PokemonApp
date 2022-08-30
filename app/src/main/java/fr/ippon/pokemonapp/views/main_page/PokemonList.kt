package fr.ippon.pokemonapp.views.main_page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.views.main_page.pokemon_card.PokemonCard

@Composable
fun PokemonList(pokemonList: List<PokemonSkeleton>, onScrollToEnd: () -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            Header()
        }
        itemsIndexed(pokemonList) { index, pokemon ->
            if (index == pokemonList.lastIndex) {
                onScrollToEnd()
            }
            PokemonCard(pokemon)
        }
    }
}