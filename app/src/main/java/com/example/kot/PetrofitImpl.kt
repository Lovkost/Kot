package com.example.kot

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl {
    private val baseUrl = "https://pokeapi.co/api/v2/"

    fun getRetrofitImpl(): PokemonApi {
        val pokeRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return pokeRetrofit.create(PokemonApi::class.java)
    }
}