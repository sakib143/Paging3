package com.example.mypractical.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mypractical.data.db.dao.TopicDao
import com.example.mypractical.data.db.table.TopicTable

@Database(
    entities = arrayOf(
        TopicTable::class,),
    version = 1,
    exportSchema = false
)

abstract class AppDatabase: RoomDatabase() {
    abstract fun getTopic(): TopicDao
}