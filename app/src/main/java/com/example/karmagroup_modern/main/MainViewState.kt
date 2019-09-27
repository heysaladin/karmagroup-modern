package com.example.karmagroup_modern.main

import com.example.karmagroup_modern.model.PokemonSet

data class MainViewState (
    var loading: Boolean = false,
    var error: Exception? = null,
    var data: MutableList<PokemonSet>? = null
)