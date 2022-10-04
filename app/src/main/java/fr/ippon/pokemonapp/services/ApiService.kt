package fr.ippon.pokemonapp.services

import fr.ippon.pokemonapp.models.fromapi.PokemonDetail
import fr.ippon.pokemonapp.models.fromapi.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    suspend fun getPokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
    ): PokemonList


    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String,
    ): PokemonDetail
}