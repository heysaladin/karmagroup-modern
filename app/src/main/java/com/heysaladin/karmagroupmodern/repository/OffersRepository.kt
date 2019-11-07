package com.heysaladin.karmagroupmodern.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.heysaladin.karmagroupmodern.model.Offers
import com.heysaladin.karmagroupmodern.model.response.ListOffersReponse
import com.heysaladin.karmagroupmodern.services.APIService
import com.heysaladin.karmagroupmodern.services.OffersAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class OffersRepository {
    private val web_service: OffersAPI

    init {
        web_service = APIService.client?.create(OffersAPI::class.java)!!
    }

    fun getOffers(category: String): LiveData<List<Offers>> {
        val data = MutableLiveData<List<Offers>>()
        val params = object : HashMap<String, String>() {
            init {
//                put("country", Main.COUNTRY)
//                put("category", category)
//                put("apiKey", Main.API_KEY)

            }
        }
        web_service.getOffersByCategory(params).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

//                Log.e("REPO", "///////// " + response.body().string())

                if (response.isSuccessful) {
                    try {
//                        val _data = "{\"status\": \"success\", \"news\": " + response.body().string().replace("\"content\":[","\"content\":").replace("],\"link\"",",\"link\"").replace("],\"snippet\"",",\"snippet\"") + "}"
                        val _data = response.body().string()
                            Log.d("JSON", _data)
                        val mGson = Gson()
//                        Log.e("REPO", "///////// " + _data.toString())
                        val response_data = mGson.fromJson(_data, ListOffersReponse::class.java)
                        if (response_data != null) {
                            //data.value = response_data.articles
                            data.value = response_data.offers
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                } else {
                    Log.d("error", "Error Parsing")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("debug", "onFailure: ERROR > $t")
            }
        })
        return data
    }

}
