package fr.ippon.pokemonapp.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ippon.pokemonapp.Constants.ITEM_PER_PAGE
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.repositories.PokemonRepository
import kotlinx.coroutines.launch


class HomeViewModel(private val repository: PokemonRepository) : ViewModel() {
    var pokemonList by mutableStateOf<List<PokemonSkeleton>>(emptyList())
        private set

    var pageNb = 0
        private set

    private val limit = ITEM_PER_PAGE

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            val newPokemons = repository.fetchList(pageNb * ITEM_PER_PAGE, limit)
            pokemonList = pokemonList + newPokemons
            pageNb++
        }
    }
}