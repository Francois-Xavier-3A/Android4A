package com.example.android4a.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.android4a.data.local.models.UserLocal


@Database(entities = arrayOf(UserLocal::class), version = 1)
public abstract class AppDatabase : RoomDatabase() {

    abstract fun databaseDao(): DataBaseDAO
}

