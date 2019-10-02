package com.heysaladin.karmamodern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmamodern.model.CategoryGroup
import com.heysaladin.karmamodern.repository.DestinationRepository

class DestinationModel : ViewModel() {
    /*Define Attribute*/
    private var repoDestination: DestinationRepository? = null
    internal lateinit var list_destination: LiveData<List<CategoryGroup>>

    fun init(repoDestination: DestinationRepository) {
        this.repoDestination = repoDestination
    }

    fun getDestinationByCategory(categ: String): LiveData<List<CategoryGroup>> {
        list_destination = this.repoDestination!!.getDestination(categ)
        return this.list_destination
    }


}
