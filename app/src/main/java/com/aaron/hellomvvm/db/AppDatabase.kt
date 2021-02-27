package com.aaron.hellomvvm.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aaron.hellomvvm.App
import com.aaron.hellomvvm.bean.Person

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@Database(entities = [Person::class], version = 1)
@TypeConverters(Converter::class)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "hello-mvvm.db"

        private val db = Room.databaseBuilder(
            App.getContext(),
            AppDatabase::class.java,
            DB_NAME
        ).build()

        fun getPersonDao(): IPersonDao {
            return db.getPersonDao()
        }
    }

    abstract fun getPersonDao(): IPersonDao
}