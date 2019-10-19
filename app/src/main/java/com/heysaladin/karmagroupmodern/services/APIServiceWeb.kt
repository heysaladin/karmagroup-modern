package com.heysaladin.karmagroupmodern.services

import com.heysaladin.karmagroupmodern.config.Main
//import com.heysaladin.karmamodern.config.Main

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object APIServiceWeb {
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(Main.URL_API_WEB)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

//    val clientNews: Retrofit?
//        get() {
//            if (retrofit == null) {
//                retrofit = Retrofit.Builder()
//                    .baseUrl(Main.URL_API_FREE)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return retrofit
//        }

}


