package com.frangovers.petsociety.api.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ArticleContent(

    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("content")
    @Expose
    var content: String? = null

)