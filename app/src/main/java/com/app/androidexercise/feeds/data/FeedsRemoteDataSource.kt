package com.app.androidexercise.feeds.data

import com.app.androidexercise.api.BaseDataSource
import com.app.androidexercise.api.FeedService
import javax.inject.Inject

class FeedsRemoteDataSource @Inject constructor(private val feedService: FeedService) : BaseDataSource() {

    suspend fun fetchFeedsData() = getResult { feedService.getFeeds() }

}
