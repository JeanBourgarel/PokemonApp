package fr.ippon.pokemonapp.viewmodels

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ippon.pokemonapp.Constants.ITEM_PER_PAGE
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.models.fromapi.Home
import fr.ippon.pokemonapp.repositories.PokemonRepository
import fr.ippon.pokemonapp.views.detail_screen.PokemonDetail
import fr.ippon.pokemonapp.views.home_screen.PokemonList
import fr.ippon.pokemonapp.views.util.ErrorScreen
import fr.ippon.pokemonapp.views.util.Loader
import kotlinx.coroutines.launch
import org.koin.androidx.compose.viewModel

sealed class HomeScreenState {
    data class Data(var data: List<PokemonSkeleton>, var loading: Boolean): HomeScreenState()
    data class Error(var reason: String): HomeScreenState()
    object Loading: HomeScreenState()
}


class HomeViewModel(private val repository: PokemonRepository) : ViewModel() {
    var homeScreenState by mutableStateOf<HomeScreenState>(HomeScreenState.Data(emptyList(), true))
        private set

    var pageNb = 0
        private set

    private val limit = ITEM_PER_PAGE

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            when(val state = homeScreenState) {
                is HomeScreenState.Data -> {
                    try {
                        val newPokemons = repository.fetchList(pageNb * ITEM_PER_PAGE, limit)
                        homeScreenState = HomeScreenState.Data(state.data + newPokemons, false)
                        pageNb++
                    } catch(e: Exception) {
                        homeScreenState = HomeScreenState.Error("An error has occured.")
                    }
                }
                else -> {}
            }
        }
    }
}