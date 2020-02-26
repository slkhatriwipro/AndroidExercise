package com.app.androidexercise.feeds.data

import com.app.androidexercise.db.resultLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedsRepository @Inject constructor(private val dao: FeedsDao,
                                          private val remoteSource: FeedsRemoteDataSource) {

    val feeds = resultLiveData(
        databaseQuery = { dao.getFeeds() },
        networkCall = { remoteSource.fetchFeedsData() },
        saveCallResult = { dao.insertAll(it.rows) })
}
