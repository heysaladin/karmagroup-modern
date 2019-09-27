package com.example.karmagroup_modern.pokemonlist

import com.example.karmagroup_modern.model.PokemonCard
import java.lang.Exception

data class PokemonListViewState (
    val loading: Boolean = false,
    val error: Exception? = null,
    val data: MutableList<PokemonCard>? = null
)