package com.example.karmagroup_modern

import android.app.Application
import com.example.karmagroup_modern.datastore.pokemon.PokemonCardLocalDataStore
import com.example.karmagroup_modern.datastore.pokemon.PokemonCardRemoteDataStore
import com.example.karmagroup_modern.datastore.set.PokemonSetLocalDataStore
import com.example.karmagroup_modern.datastore.set.PokemonSetRemoteDataStore
import com.example.karmagroup_modern.repository.PokemonCardRepository
import com.example.karmagroup_modern.repository.PokemonSetRepository
import com.example.karmagroup_modern.webservice.RetrofitApp

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val pokemonTcgService = RetrofitApp.POKEMON_TCG_SERVICE
        PokemonSetRepository.instance.apply {
            init(PokemonSetLocalDataStore(), PokemonSetRemoteDataStore(pokemonTcgService))
        }

        PokemonCardRepository.instance.apply {
            init(PokemonCardLocalDataStore(), PokemonCardRemoteDataStore(pokemonTcgService))
        }
    }
}