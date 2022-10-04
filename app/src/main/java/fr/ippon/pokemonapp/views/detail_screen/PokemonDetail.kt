package fr.ippon.pokemonapp.views.detail_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton

@Composable
fun PokemonDetail(pokemonDetailSkeleton: PokemonDetailSkeleton, onClick: () -> Unit) {
    Column {
        Text(
            modifier = Modifier.clickable { onClick() },
            text = pokemonDetailSkeleton.name,
            color = Color.White
        )
        Text(
            modifier = Modifier.clickable { onClick() },
            text = pokemonDetailSkeleton.id.toString(),
            color = Color.White
        )
        LazyRow {
            itemsIndexed(pokemonDetailSkeleton.types) { index, type ->
                Text(
                    modifier = Modifier.clickable { onClick() },
                    text = "$type ",
                    color = Color.White
                )
            }
        }
    }
}