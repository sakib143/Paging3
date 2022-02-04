package com.example.mypractical.data.db.dao

import androidx.room.*
import com.example.mypractical.data.db.table.TopicTable

@Dao
interface TopicDao {

    @Query("SELECT * FROM topics_main")
    fun getTopiList(): TopicTable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopic(topic: TopicTable) : Long

//    @Delete
//    fun deleteCategory(model: String) : Int

}