package fr.ippon.pokemonapp.views.main_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.ippon.pokemonapp.R
import fr.ippon.pokemonapp.ui.theme.LatoFamily

@Composable
fun Header() {
    Row(
        Modifier.padding(vertical = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painterResource(R.drawable.pokeball_icon), "content description")
        Text(
            color = Color.White,
            fontFamily = LatoFamily,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            text = "Pokedex",
        )
        Image(painterResource(R.drawable.pokeball_icon), "content description")
    }
}