package fr.ippon.pokemonapp.repositories

import fr.ippon.pokemonapp.Helpers.getPokemonId
import fr.ippon.pokemonapp.Helpers.getPokemonSpriteURL
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.models.app.StatsSkeleton
import fr.ippon.pokemonapp.models.fromapi.PokemonDetail
import fr.ippon.pokemonapp.models.fromapi.PokemonList
import fr.ippon.pokemonapp.models.fromapi.toSkeleton
import fr.ippon.pokemonapp.services.ApiService
import kotlinx.coroutines.delay

class RealPokemonRepository(service: ApiService) : PokemonRepository(service) {

    override suspend fun fetchList(offset: Int, limit: Int): List<PokemonSkeleton> {
        return try {
            val pokemonListFromAPI = service.getPokemons(offset, limit)
            pokemonListFromAPI.toSkeleton()
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getDetail(pokemonName: String): PokemonDetailSkeleton {
        return try {
            val pokemonDetailFromAPI = service.getPokemonDetail(pokemonName)
            pokemonDetailFromAPI.toSkeleton()
        } catch (e: Exception) {
            throw e
        }
    }
}

