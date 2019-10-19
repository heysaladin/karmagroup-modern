package com.heysaladin.karmagroupmodern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmagroupmodern.model.Offers
import com.heysaladin.karmagroupmodern.repository.OffersRepository

class OffersModel : ViewModel() {
    /*Define Attribute*/
    private var repo: OffersRepository? = null
//    private var repoDestination: DestinationRepository? = null
    internal lateinit var list_news: LiveData<List<Offers>>
//    internal lateinit var list_destination: LiveData<List<CategoryGroup>>

    fun init(repo: OffersRepository) {
        this.repo = repo
    }

    fun getOffersByCategory(categ: String): LiveData<List<Offers>> {
        list_news = this.repo!!.getOffers(categ)
        return this.list_news
    }


}
