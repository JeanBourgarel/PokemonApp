package fr.ippon.pokemonapp.models.fromapi

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: String?,
    val results: List<Result>
)