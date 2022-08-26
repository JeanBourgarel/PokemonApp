package fr.ippon.pokemonapp.repositories

import fr.ippon.pokemonapp.Helpers.getPokemonSpriteURL
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.services.ApiService

class FakePokemonRepository(service: ApiService) : PokemonRepository(service) {
    override suspend fun fetchList(offset: Int, limit: Int): List<PokemonSkeleton> {
        return fakeMyPokemonLists
    }
}

private val fakeMyPokemonLists: List<PokemonSkeleton> = listOf(
    PokemonSkeleton(1,"Bulbasaur", getPokemonSpriteURL(1)),
    PokemonSkeleton(4, "Salamander", getPokemonSpriteURL(4)),
    PokemonSkeleton(7, "Squirtle", getPokemonSpriteURL(7))
)

