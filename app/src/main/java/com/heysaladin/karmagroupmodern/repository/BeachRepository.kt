package com.heysaladin.karmagroupmodern.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.heysaladin.karmagroupmodern.model.Beach
import com.heysaladin.karmagroupmodern.model.News
import com.heysaladin.karmagroupmodern.model.response.ListBeachReponse
import com.heysaladin.karmagroupmodern.model.response.ListNewsReponse
import com.heysaladin.karmagroupmodern.services.APIService
import com.heysaladin.karmagroupmodern.services.BeachAPI
import com.heysaladin.karmagroupmodern.services.NewsAPI
//import com.heysaladin.karmamodern.model.News
//import com.heysaladin.karmamodern.model.response.ListNewsReponse
//import com.heysaladin.karmamodern.services.APIService
//import com.heysaladin.karmamodern.services.NewsAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class BeachRepository {
    private val web_service: BeachAPI

    init {
        web_service = APIService.client?.create(BeachAPI::class.java)!!
    }

    fun getBeach(category: String): LiveData<List<Beach>> {
        val data = MutableLiveData<List<Beach>>()
        val params = object : HashMap<String, String>() {
            init {
//                put("country", Main.COUNTRY)
//                put("category", category)
//                put("apiKey", Main.API_KEY)

            }
        }
        web_service.getNewsByCategory(params).enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {

//                Log.e("REPO", "///////// " + response.body().string())

                if (response.isSuccessful) {
                    try {
                        val _data = "{\"status\": \"success\", \"news\": " + response.body().string().replace("\"content\":[","\"content\":").replace("],\"link\"",",\"link\"").replace("],\"snippet\"",",\"snippet\"") + "}"
                        Log.d("JSON", _data)
                        val mGson = Gson()
//                        Log.e("REPO", "///////// " + _data.toString())
                        val response_data = mGson.fromJson(_data, ListBeachReponse::class.java)
                        if (response_data != null) {
                            //data.value = response_data.articles
                            data.value = response_data.news
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