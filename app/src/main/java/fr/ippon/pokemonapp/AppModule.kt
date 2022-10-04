package fr.ippon.pokemonapp

import fr.ippon.pokemonapp.Constants.API_URL
import fr.ippon.pokemonapp.repositories.FakePokemonRepository
import fr.ippon.pokemonapp.repositories.PokemonRepository
import fr.ippon.pokemonapp.repositories.RealPokemonRepository
import fr.ippon.pokemonapp.services.ApiService
import fr.ippon.pokemonapp.viewmodels.DetailViewModel
import fr.ippon.pokemonapp.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {
    single<PokemonRepository> {
        RealPokemonRepository(get())
    }

    single<ApiService> {
        Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create();
    }

    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}