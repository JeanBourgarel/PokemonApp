package fr.ippon.pokemonapp

import fr.ippon.pokemonapp.Constants.DEFAULT_SPRITE_URL

object Helpers {
    fun getPokemonId(url: String): Int {
        val str = url.dropLast(1)
        val id = str.substringAfterLast("/")
        return id.toInt()
    }

    fun getPokemonSpriteURL(id: Int): String {
        return "${DEFAULT_SPRITE_URL + id}.png"
    }
}