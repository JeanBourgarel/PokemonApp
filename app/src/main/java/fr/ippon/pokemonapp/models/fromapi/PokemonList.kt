package fr.ippon.pokemonapp.models.fromapi

import fr.ippon.pokemonapp.Helpers
import fr.ippon.pokemonapp.models.app.PokemonSkeleton

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Result>
)

fun PokemonList.toSkeleton(): List<PokemonSkeleton> {
    return this.results.map { pokemon ->
        val id: Int = Helpers.getPokemonId(pokemon.url)
        val name: String = pokemon.name.replaceFirstChar { it.uppercaseChar() }
        val url: String = Helpers.getPokemonSpriteURL(id)
        PokemonSkeleton(id, name, url)
    }
}