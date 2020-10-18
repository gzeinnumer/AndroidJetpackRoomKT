package com.gzeinnumer.androidjetpackroomkt.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gzeinnumer.androidjetpackroomkt.data.room.dao.SampleTableDao
import com.gzeinnumer.androidjetpackroomkt.model.SampleTable

@Database(entities = [SampleTable::class], version = 3)
abstract class AppDatabase : RoomDatabase() {

    abstract fun sampleTableDao(): SampleTableDao

    companion object {

        private val TAG = "AppDatabase"
        private val dbName = "ExternalBase64Md5ToZip.db"

        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java,
                dbName
            )
                .setJournalMode(JournalMode.TRUNCATE)
                .allowMainThreadQueries()
                .build()
        }
    }
}