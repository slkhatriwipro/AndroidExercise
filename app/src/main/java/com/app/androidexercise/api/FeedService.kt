package com.app.androidexercise.api

import com.app.androidexercise.feeds.data.Rows
import retrofit2.Response
import retrofit2.http.GET

interface FeedService {
    companion object {
        const val ENDPOINT = "https://dl.dropboxusercontent.com/"
    }

    @GET("s/2iodh4vg0eortkl/facts.json")
    suspend fun getFeeds(): Response<ResultsResponse<Rows>>
}