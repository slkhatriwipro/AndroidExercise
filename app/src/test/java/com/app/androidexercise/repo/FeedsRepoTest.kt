package com.app.androidexercise.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.app.androidexercise.api.FeedService
import com.app.androidexercise.db.AppDatabase
import com.app.androidexercise.feeds.data.FeedsDao
import com.app.androidexercise.feeds.data.FeedsRemoteDataSource
import com.app.androidexercise.feeds.data.FeedsRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

@RunWith(JUnit4::class)
class FeedsRepoTest {
    private lateinit var repository: FeedsRepository
    private val dao = mock(FeedsDao::class.java)
    private val service = mock(FeedService::class.java)
    private val remoteDataSource = FeedsRemoteDataSource(service)

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        val db = mock(AppDatabase::class.java)
        `when`(db.feedsDao()).thenReturn(dao)
        `when`(db.runInTransaction(ArgumentMatchers.any())).thenCallRealMethod()
        repository = FeedsRepository(dao, remoteDataSource)
    }

    @Test
    fun loadLegoSetsFromNetwork() {
        runBlocking {
            repository.feeds

            verify(dao, never()).getFeeds()
        }
    }
}