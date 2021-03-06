package com.heysaladin.karmagroupmodern.services

//import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface BeachAPI {

    /*Get Top Head Lines*/
    @GET("karma-beach/api/?method=getEvents&filter=onGoing&usedIn=app")
    fun getNewsByCategory(@QueryMap params: Map<String, String>): retrofit2.Call<ResponseBody>

}
