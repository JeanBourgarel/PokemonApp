package fr.ippon.pokemonapp.models.fromapi

import fr.ippon.pokemonapp.Helpers
import fr.ippon.pokemonapp.models.app.PokemonDetailSkeleton
import fr.ippon.pokemonapp.models.app.StatsSkeleton

data class PokemonDetail(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)

fun PokemonDetail.toSkeleton(): PokemonDetailSkeleton {
    val id = this.id
    val name = this.name
    val imgURL = Helpers.getPokemonSpriteURL(this.id)
    val types = this.types.map { type ->
        type.type.name
    }
    val stats = StatsSkeleton(
        hp = this.stats[0].base_stat,
        atk = this.stats[1].base_stat,
        def = this.stats[2].base_stat,
        sp_atk = this.stats[3].base_stat,
        sp_def = this.stats[4].base_stat,
        spd = this.stats[5].base_stat,
    )
    return PokemonDetailSkeleton(id, name, imgURL, types, stats)
}