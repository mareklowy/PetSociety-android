package com.frangovers.petsociety.api

import com.frangovers.petsociety.BuildConfig
import com.frangovers.petsociety.api.requests.ExampleRequest
import com.frangovers.petsociety.api.requests.ExampleResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface RouterInterface {

    companion object Factory {

        val okHttpClient =
            OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .build()

        fun create(): RouterInterface {
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RouterInterface::class.java)
        }
    }

    @Headers("Content-type: application/json")
    @POST("/path/{userId}")
    fun postExample(
        @Body body: ExampleRequest,
        @Header("x-api-key") apiKey: String = "User.currentlyLoggedInUser()?.apiKey",
        @Path("userId") userId: String = "ID-666"
    ): Call<Unit>

    @GET("/path/{userId}")
    fun getExample(
        @Header("x-api-key") apiKey: String = "",
        @Path("userId") userId: String = ""
    ): Call<ExampleResponse>
}