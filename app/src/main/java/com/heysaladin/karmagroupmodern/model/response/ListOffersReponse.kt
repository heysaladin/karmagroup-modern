package com.heysaladin.karmagroupmodern.model.response

import com.heysaladin.karmagroupmodern.model.CategoryGroup
import com.heysaladin.karmagroupmodern.model.News
import com.heysaladin.karmagroupmodern.model.Offers

class ListOffersReponse {
    var status: String? = null
    var totalResults: Int = 0
    //var articles: List<News>? = null
    var offers: List<CategoryGroup>? = null
    var news: List<Offers>? = null
}
