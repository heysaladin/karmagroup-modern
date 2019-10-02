package com.heysaladin.karmamodern.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface DestinationAPI {

    /*Get Top Head Lines*/
    @GET("v1.8.5/getKarmaGroups.php/")
    fun getDestinationByCategory(@QueryMap params: Map<String, String>): Call<ResponseBody>

}
