package fr.ippon.pokemonapp.views.main_page.pokemon_card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.ippon.pokemonapp.models.app.PokemonSkeleton

@Composable
fun PokemonCard(pokemon: PokemonSkeleton, modifier: Modifier = Modifier) {
    var backgroundColor by remember { mutableStateOf(Color.DarkGray) }
    var gradientColor by remember { mutableStateOf(Color.Black) }
    Card(
        backgroundColor = backgroundColor,
        elevation = 5.dp,
        shape = RoundedCornerShape(15),
    ) {
        Column(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            gradientColor
                        ),
                        startY = 250f
                    )
                )
                .padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PokemonImage(
                imgURL = pokemon.imgURL,
                onLoaded = { bgColor, gdColor ->
                    backgroundColor = bgColor
                    gradientColor = gdColor
                },
            )
            PokemonCardTitle(name = pokemon.name, id = pokemon.id)
        }
    }
}