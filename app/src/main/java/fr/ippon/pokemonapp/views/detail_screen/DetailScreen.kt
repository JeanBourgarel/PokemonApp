package fr.ippon.pokemonapp.views.detail_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import fr.ippon.pokemonapp.viewmodels.DetailScreenState
import fr.ippon.pokemonapp.viewmodels.DetailViewModel
import fr.ippon.pokemonapp.views.util.ErrorScreen
import fr.ippon.pokemonapp.views.util.Loader
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailScreen(viewModel: DetailViewModel = getViewModel(), pokemonName: String?, onClick: () -> Unit) {
    val name = checkNotNull(pokemonName).replaceFirstChar { it.lowercaseChar() }
    LaunchedEffect(Unit){
        viewModel.getDetail(name)
    }
    when(val state = viewModel.detailScreenState) {
        is DetailScreenState.Data -> {
            PokemonDetail(
                pokemonDetailSkeleton = state.data,
                onClick = onClick
            )
        }
        is DetailScreenState.Error -> {
            ErrorScreen(onClick = {
                viewModel.getDetail(name)
            })
        }
        is DetailScreenState.Loading -> {
            Loader()
        }
    }
}