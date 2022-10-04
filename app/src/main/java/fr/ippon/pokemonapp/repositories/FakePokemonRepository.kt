package fr.ippon.pokemonapp.repositories

import fr.ippon.pokemonapp.Helpers.getPokemonSpriteURL
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton
import fr.ippon.pokemonapp.models.app.PokemonSkeleton
import fr.ippon.pokemonapp.models.app.StatsSkeleton
import fr.ippon.pokemonapp.services.ApiService

class FakePokemonRepository(service: ApiService) : PokemonRepository(service) {
    override suspend fun fetchList(offset: Int, limit: Int): List<PokemonSkeleton> {
        return fakeMyPokemonLists
    }

    override suspend fun getDetail(pokemonName: String): PokemonDetailSkeleton {
        return fakeMyPokemonDetail
    }
}

private val fakeMyPokemonDetail : PokemonDetailSkeleton = PokemonDetailSkeleton(
    id = 1,
    name = "bulbasaur",
    imgURL = getPokemonSpriteURL(1),
    types = listOf("grass", "poison"),
    stats = StatsSkeleton(
        hp = 20,
        atk = 12,
        def = 10,
        sp_atk = 15,
        sp_def = 12,
        spd = 8
    )
)

private val fakeMyPokemonLists: List<PokemonSkeleton> = listOf(
    PokemonSkeleton(1,"Bulbasaur", getPokemonSpriteURL(1)),
    PokemonSkeleton(4, "Salamander", getPokemonSpriteURL(4)),
    PokemonSkeleton(7, "Squirtle", getPokemonSpriteURL(7))
)

