package com.example.karmagroup_modern.repository

import com.example.karmagroup_modern.datastore.set.PokemonSetDataStore
import com.example.karmagroup_modern.datastore.set.PokemonSetRemoteDataStore
import com.example.karmagroup_modern.model.PokemonSet

class PokemonSetRepository private constructor() : BaseRepository<PokemonSetDataStore>() {
    suspend fun getSets(): MutableList<PokemonSet>? {
        val cache = localDataStore?.getSets()
        if (cache != null) return cache
        val response = remoteDataStore?.getSets()
        localDataStore?.addAll(response)
        return response
    }

    companion object {
        val instance by lazy { PokemonSetRepository() }
    }
}

