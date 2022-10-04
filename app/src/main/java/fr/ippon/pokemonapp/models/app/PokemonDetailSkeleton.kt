package fr.ippon.pokemonapp.models.app

data class PokemonDetailSkeleton(
    val id: Int,
    val name: String,
    val imgURL: String,
    val types: List<String>,
    val stats: StatsSkeleton
)