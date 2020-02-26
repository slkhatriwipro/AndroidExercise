package com.app.androidexercise.feeds.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedsDao {
    @Query("SELECT * FROM rows")
    fun getFeeds(): LiveData<List<Rows>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<Rows>)
}