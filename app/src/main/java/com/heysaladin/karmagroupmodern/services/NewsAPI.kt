package com.heysaladin.karmagroupmodern.services

//import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsAPI {

    /*Get Top Head Lines*/
    @GET("getAllNews.php/")
    fun getNewsByCategory(@QueryMap params: Map<String, String>): retrofit2.Call<ResponseBody>

}
