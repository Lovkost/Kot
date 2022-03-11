package com.example.kot

import com.google.gson.annotations.SerializedName

data class ServerResponseData(
//    @field:SerializedName("name") val name:String?,
    @field:SerializedName("results") val results:List<PokemonResponse>,
//    @field:SerializedName("sprites") val sprites:PokeImage
)
data class PokemonResponse(
    @field:SerializedName("name") val name: String?,
    @field:SerializedName("url") val url:String?
)
data class PokemonImageResponse(
    @field:SerializedName("sprites") val sprites:PokeImage
)
data class PokeImage(
    @field:SerializedName("front_default") val front_default:String
)
