package com.heysaladin.karmamodern.model.response

import com.heysaladin.karmamodern.model.CategoryGroup

class ListNewsReponse {
    var status: String? = null
    var totalResults: Int = 0
    //var articles: List<News>? = null
    var offers: List<CategoryGroup>? = null
}
