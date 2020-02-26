package com.app.androidexercise.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.app.androidexercise.feeds.data.FeedsDao
import com.app.androidexercise.feeds.data.Rows

/**
 * The Room database for this app
 */
@Database(entities = [Rows::class],
        version = 1, exportSchema = false)

abstract class AppDatabase : RoomDatabase() {

    abstract fun feedsDao(): FeedsDao

    companion object {

        // Singleton
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create the database.
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "feeds-db")
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }
                    })
                    .build()
        }
    }
}
