package fr.ippon.pokemonapp.models.fromapi

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)