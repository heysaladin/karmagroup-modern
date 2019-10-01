package com.heysaladin.karmamodern.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsAPI {

    /*Get Top Head Lines*/
    @GET("top-headlines")
    fun getNewsByCategory(@QueryMap params: Map<String, String>): Call<ResponseBody>

}
