package com.example.kot

sealed class PokemonData {
    data class Success(val serverResponseData: ServerResponseData?):PokemonData()
    data class Loading(val progress: Int?):PokemonData()
    data class Error(val error:Throwable):PokemonData()
}