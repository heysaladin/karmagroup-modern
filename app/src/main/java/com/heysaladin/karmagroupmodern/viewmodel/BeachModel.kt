package com.heysaladin.karmagroupmodern.viewmodel

//import android.arch.lifecycle.LiveData
//import android.arch.lifecycle.ViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmagroupmodern.model.Beach
import com.heysaladin.karmagroupmodern.model.CategoryGroup
import com.heysaladin.karmagroupmodern.model.News
import com.heysaladin.karmagroupmodern.repository.BeachRepository
import com.heysaladin.karmagroupmodern.repository.DestinationRepository
import com.heysaladin.karmagroupmodern.repository.NewsRepository
//import com.heysaladin.karmamodern.model.News
//import com.heysaladin.karmamodern.repository.NewsRepository

class BeachModel  : ViewModel() {
    /*Define Attribute*/
    private var repoBeach: BeachRepository? = null
    internal lateinit var list_beach: LiveData<List<Beach>>

    fun init(repoBeach: BeachRepository) {
        this.repoBeach = repoBeach
    }

    fun getBeachByCategory(categ: String): LiveData<List<Beach>> {
        list_beach = this.repoBeach!!.getBeach(categ)
        return this.list_beach
    }


}