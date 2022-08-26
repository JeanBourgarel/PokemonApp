package fr.ippon.pokemonapp.views.main_page

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.ui.theme.LatoFamily

private fun addZerosToId(id: Int): String {
    val str = id.toString()
    if (str.length == 1)
        return "00$str"
    if (str.length == 2)
        return "0$str"
    return str
}

@Composable
fun PokemonCard(pokemon: PokemonSkeleton, modifier: Modifier = Modifier) {
    var isLoading by remember { mutableStateOf(true) }

    Card(
        border = BorderStroke(2.dp, Color.Blue),
        shape = RoundedCornerShape(10)
    ) {
        Column(
            modifier = Modifier.padding(bottom = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box {
                AsyncImage(
                    modifier = Modifier.size(150.dp),
                    model = pokemon.imgURL,
                    contentDescription = null,
                    onSuccess = { isLoading = false }
                )
                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            Text(
                fontFamily = LatoFamily,
                textAlign = TextAlign.Center,
                text = pokemon.name + "\n" + addZerosToId(pokemon.id),
            )
        }
    }
}