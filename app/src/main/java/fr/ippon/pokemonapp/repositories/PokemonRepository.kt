package fr.ippon.pokemonapp.repositories

import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.services.ApiService

abstract class PokemonRepository(val service: ApiService) {
    abstract suspend fun fetchList(offset: Int, limit: Int): List<PokemonSkeleton>
}