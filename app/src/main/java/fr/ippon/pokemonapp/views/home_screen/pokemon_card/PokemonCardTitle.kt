package fr.ippon.pokemonapp.views.home_screen.pokemon_card

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
fun PokemonCardTitle(modifier: Modifier = Modifier, name: String, id: Int) {
    Card(
        backgroundColor = Color.White,
        shape = RoundedCornerShape(15)
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            fontFamily = LatoFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            text = name + "\n#" + addZerosToId(id),
        )
    }
}