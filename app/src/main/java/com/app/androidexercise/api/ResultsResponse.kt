package com.app.androidexercise.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class ResultsResponse<T>(
    /* @SerializedName("count")
     val count: Int,
     @SerializedName("next")
     val next: String? = null,
     @SerializedName("previous")
     val previous: String? = null,
     @SerializedName("results")
     val results: List<T>,*/

    @SerializedName("title")
    val title: String? = null,
    @SerializedName("rows")
    val rows: List<T>
)
