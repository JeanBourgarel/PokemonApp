package fr.ippon.pokemonapp.views.home_screen.pokemon_card

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import coil.compose.AsyncImage

private fun getVibrantColor(vibrantSwatch: Palette.Swatch?): Color {
    val vibrantColor = vibrantSwatch?.rgb?.let { Color(it) }
    if (vibrantColor != null) {
        return vibrantColor
    }
    return Color.Black
}

@Composable
fun PokemonImage(
    modifier: Modifier = Modifier,
    imgURL: String,
    onLoaded: (Color, Color) -> Unit
) {
    var isLoading by remember { mutableStateOf(true) }

    Box {
        AsyncImage(
            modifier = Modifier
                .size(150.dp),
            model = imgURL,
            contentDescription = null,
            onSuccess = { state ->
                val bitmap =
                    state.result.drawable.toBitmap().copy(Bitmap.Config.RGBA_F16, true)

                val palette = Palette.from(bitmap).generate()
                onLoaded(
                    getVibrantColor(palette.vibrantSwatch),
                    getVibrantColor(palette.darkVibrantSwatch)
                )
                isLoading = false
            }
        )
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}