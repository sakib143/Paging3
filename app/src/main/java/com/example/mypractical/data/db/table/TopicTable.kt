package com.example.mypractical.data.db.table


import androidx.annotation.Keep
import androidx.room.*

@Entity(
    tableName = "topics_main"
)
@Keep
data class TopicTable(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    @ColumnInfo(name = "data")
    val data: String,
)