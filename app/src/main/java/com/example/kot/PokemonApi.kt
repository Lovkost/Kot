package com.example.kot

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.security.auth.callback.Callback

interface PokemonApi {
    @GET("pokemon?limit=100")
    fun getPokemon(): Call<ServerResponseData>
    @GET("pokemon/1")
    fun GetPokemonImage():Call<PokemonImageResponse>
}