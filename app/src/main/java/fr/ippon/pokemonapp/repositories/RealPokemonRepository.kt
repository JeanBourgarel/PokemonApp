package fr.ippon.pokemonapp.repositories

import fr.ippon.pokemonapp.Helpers.getPokemonId
import fr.ippon.pokemonapp.Helpers.getPokemonSpriteURL
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.models.fromapi.PokemonList
import fr.ippon.pokemonapp.services.ApiService


class RealPokemonRepository(service: ApiService) : PokemonRepository(service) {

    private fun pokemonListToSkeleton(apiList: PokemonList): List<PokemonSkeleton> {
        return apiList.results.map { pokemon ->
            val id: Int = getPokemonId(pokemon.url)
            val name: String = pokemon.name.replaceFirstChar { it.uppercaseChar() }
            val url: String = getPokemonSpriteURL(id)
            PokemonSkeleton(id, name, url)
        }
    }

    override suspend fun fetchList(offset: Int, limit: Int): List<PokemonSkeleton> {
        return try {
            val pokemonList = service.getPokemons(offset, limit)
            pokemonListToSkeleton(pokemonList)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

