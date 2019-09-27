package com.example.karmagroup_modern.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.karmagroup_modern.repository.PokemonCardRepository

class PokemonListViewModelFactory(
        private val pokemonRepository: PokemonCardRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java))
            return PokemonListViewModel(pokemonRepository) as T
        throw IllegalArgumentException()
    }
}