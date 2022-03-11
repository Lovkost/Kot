package com.example.kot

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response

class PokemonViewModel(
    private val liveDataForViewToObserve: MutableLiveData<PokemonData> = MutableLiveData(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl()
) : ViewModel() {
    var image: String = ""

    fun getData(): MutableLiveData<PokemonData> {
        sendServerRequest()
        return liveDataForViewToObserve
    }


    private fun sendServerRequest() {
        liveDataForViewToObserve.value = PokemonData.Loading(null)
        retrofitImpl.getRetrofitImpl().getPokemon()
            .enqueue(object : retrofit2.Callback<ServerResponseData> {
                override fun onResponse(
                    call: Call<ServerResponseData>,
                    response: Response<ServerResponseData>
                ) {
                    liveDataForViewToObserve.value = PokemonData.Success(response.body())
                }

                override fun onFailure(call: Call<ServerResponseData>, t: Throwable) {
                    liveDataForViewToObserve.value = PokemonData.Error(t)
                }

            })

    }
}