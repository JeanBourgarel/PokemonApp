package fr.ippon.pokemonapp

object Helpers {
    fun getPokemonId(url: String): Int {
        val str = url.dropLast(1)
        val id = str.substringAfterLast("/")
        return id.toInt()
    }

    fun getPokemonSpriteURL(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
    }
}