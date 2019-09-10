package com.frangovers.petsociety.api.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExampleRequest(

    @SerializedName("jsonTag")
    @Expose
    var tag: String? = null

)