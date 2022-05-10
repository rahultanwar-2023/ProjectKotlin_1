package com.example.projectroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "myinfo_table")
data class MyInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val mother: String,
    val age: Int
)
