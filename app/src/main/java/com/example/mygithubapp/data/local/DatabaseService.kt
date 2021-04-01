package com.example.mygithubapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mygithubapp.data.local.dao.DummyDao
import com.example.mygithubapp.data.local.entity.DummyEntity
import javax.inject.Singleton

@Singleton
@Database(
    entities = [
        DummyEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun dummyDao(): DummyDao

}