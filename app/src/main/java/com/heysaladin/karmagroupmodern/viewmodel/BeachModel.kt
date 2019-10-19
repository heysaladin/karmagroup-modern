package com.heysaladin.karmagroupmodern.viewmodel

//import android.arch.lifecycle.LiveData
//import android.arch.lifecycle.ViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmagroupmodern.model.Beach
import com.heysaladin.karmagroupmodern.model.News
import com.heysaladin.karmagroupmodern.repository.BeachRepository
import com.heysaladin.karmagroupmodern.repository.NewsRepository
//import com.heysaladin.karmamodern.model.News
//import com.heysaladin.karmamodern.repository.NewsRepository

class BeachModel : ViewModel() {
    /*Define Attribute*/
    private var repo: BeachRepository? = null
//    private var repoDestination: DestinationRepository? = null
    internal lateinit var list_news: LiveData<List<Beach>>
//    internal lateinit var list_destination: LiveData<List<CategoryGroup>>

    fun init(repo: BeachRepository) {
        this.repo = repo
    }

    fun getBeachByCategory(categ: String): LiveData<List<Beach>> {
        list_news = this.repo!!.getBeach(categ)
        return this.list_news
    }


}
