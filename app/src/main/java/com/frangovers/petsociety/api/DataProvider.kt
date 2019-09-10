package com.frangovers.petsociety.api

import android.util.Log
import com.frangovers.petsociety.api.requests.ExampleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataProvider {
    private val routerService = RouterInterface.create()

    fun getExample(userId: String, completion: (response: String, ExampleResponse?) -> Unit) {
        val call = routerService.getExample(userId)

        call.enqueue(object : Callback<ExampleResponse> {
            override fun onResponse(
                call: Call<ExampleResponse>?,
                response: Response<ExampleResponse>?
            ) {
                response?.code()?.also { statusCode ->
                    when (statusCode) {
                        200, 201 -> {
                            completion("OK", response.body())
                        }

                        else -> {
                            completion("BAD", null)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ExampleResponse>, t: Throwable) {
                Log.d("submitShortAnswer", t.toString())
                completion("BAD", null)
            }
        })
    }
}