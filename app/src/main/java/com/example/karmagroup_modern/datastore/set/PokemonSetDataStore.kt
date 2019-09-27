package com.example.karmagroup_modern.datastore.set

import com.example.karmagroup_modern.model.PokemonSet

interface PokemonSetDataStore {
    suspend fun getSets(): MutableList<PokemonSet>?
    suspend fun addAll(sets: MutableList<PokemonSet>?)
}