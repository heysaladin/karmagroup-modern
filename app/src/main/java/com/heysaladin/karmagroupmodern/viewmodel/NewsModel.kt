package com.heysaladin.karmagroupmodern.viewmodel

//import android.arch.lifecycle.LiveData
//import android.arch.lifecycle.ViewModel
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmagroupmodern.model.News
import com.heysaladin.karmagroupmodern.repository.NewsRepository
//import com.heysaladin.karmamodern.model.News
//import com.heysaladin.karmamodern.repository.NewsRepository

class NewsModel : ViewModel() {
    /*Define Attribute*/
    private var repo: NewsRepository? = null
//    private var repoDestination: DestinationRepository? = null
    internal lateinit var list_news: LiveData<List<News>>
//    internal lateinit var list_destination: LiveData<List<CategoryGroup>>

    fun init(repo: NewsRepository) {
        this.repo = repo
    }

    fun getNewsByCategory(categ: String): LiveData<List<News>> {
        list_news = this.repo!!.getNews(categ)
        return this.list_news
    }


}
