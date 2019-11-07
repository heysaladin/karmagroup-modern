package com.heysaladin.karmagroupmodern.services

//import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OffersAPI {

    /*Get Top Head Lines*/
    @GET("karmaOffers.php/")
    fun getOffersByCategory(@QueryMap params: Map<String, String>): retrofit2.Call<ResponseBody>

}
