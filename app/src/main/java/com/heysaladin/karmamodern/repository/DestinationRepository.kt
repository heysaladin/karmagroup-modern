package com.heysaladin.karmamodern.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.heysaladin.karmamodern.config.Main
import com.heysaladin.karmamodern.model.CategoryGroup
import com.heysaladin.karmamodern.model.response.ListNewsReponse
import com.heysaladin.karmamodern.services.APIService
import com.heysaladin.karmamodern.services.DestinationAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class DestinationRepository {
    private val web_service: DestinationAPI

    init {
        web_service = APIService.client?.create(DestinationAPI::class.java)!!
    }

    fun getDestination(category: String): LiveData<List<CategoryGroup>> {
        val data = MutableLiveData<List<CategoryGroup>>()
        val params = object : HashMap<String, String>() {
            init {
                put("country", Main.COUNTRY)
                put("category", category)
                put("apiKey", Main.API_KEY)

            }
        }
        web_service.getDestinationByCategory(params).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

                if (response.isSuccessful) {
                    try {
                        val _data = response.body().string()
                        Log.d("JSON", _data)
                        val mGson = Gson()
                        val response_data = mGson.fromJson(_data, ListNewsReponse::class.java)
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
