package com.example.karmagroup_modern.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.karmagroup_modern.R
import com.example.karmagroup_modern.model.PokemonSet
import com.example.karmagroup_modern.pokemonlist.PokemonListActivity
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_main.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val pokemonSets = mutableListOf<PokemonSet>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
    )

    override fun getItemCount() = pokemonSets.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pokemonSets[position])
    }

    fun updateData(newPokemonSets: MutableList<PokemonSet>) {
        pokemonSets.clear()
        pokemonSets.addAll(newPokemonSets)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(item: PokemonSet) {
            Glide.with(containerView!!)
                .load(item.logo)
                .into(ivSetLogo)

            tvSetName.text = item.name
            containerView?.setOnClickListener {
                containerView?.context?.let {
                    val intent = Intent(it, PokemonListActivity::class.java)
                        .putExtra(PokemonListActivity.EXTRA_SET, item.name)
                    it.startActivity(intent)
                }
            }
        }
    }
}
