package fr.ippon.pokemonapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ippon.pokemonapp.Constants.ITEM_PER_PAGE
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.repositories.PokemonRepository
import kotlinx.coroutines.launch

sealed class DetailScreenState {
    data class Data(var data: PokemonDetailSkeleton): DetailScreenState()
    data class Error(var reason: String): DetailScreenState()
    object Loading: DetailScreenState()
}

class DetailViewModel(private val repository: PokemonRepository) : ViewModel() {
    var detailScreenState by mutableStateOf<DetailScreenState>(DetailScreenState.Loading)
        private set


    fun getDetail(pokemonName: String) {
        viewModelScope.launch {
            detailScreenState = DetailScreenState.Loading
            detailScreenState = try {
                val detail = repository.getDetail(pokemonName)
                DetailScreenState.Data(detail)
            } catch(e: Exception) {
                DetailScreenState.Error("An error has occured.")
            }
        }
    }
}