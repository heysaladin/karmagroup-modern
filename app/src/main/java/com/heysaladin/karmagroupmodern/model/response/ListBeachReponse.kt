package com.heysaladin.karmagroupmodern.model.response

import com.heysaladin.karmagroupmodern.model.Beach
import com.heysaladin.karmagroupmodern.model.CategoryGroup
import com.heysaladin.karmagroupmodern.model.News
import org.json.JSONObject

class ListBeachReponse {
    var status: String? = null
    var totalResults: Int = 0
    //var articles: List<News>? = null
    var offers: List<CategoryGroup>? = null
    var beach: Beach? = null
    var beachList: List<Beach>? = null
    var data: JSONObject = {
        beachList
    }
}
