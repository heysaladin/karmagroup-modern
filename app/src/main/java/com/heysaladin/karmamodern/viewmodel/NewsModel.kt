package com.heysaladin.karmamodern.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.heysaladin.karmamodern.model.CategoryGroup
import com.heysaladin.karmamodern.repository.NewsRepository

class NewsModel : ViewModel() {
    /*Define Attribute*/
    private var repo: NewsRepository? = null
    internal lateinit var list_news: LiveData<List<CategoryGroup>>

    fun init(repo: NewsRepository) {
        this.repo = repo
    }

    fun getNewsByCategory(categ: String): LiveData<List<CategoryGroup>> {
        list_news = this.repo!!.getNews(categ)
        return this.list_news
    }

}
