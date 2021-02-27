package com.aaron.hellomvvm.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aaron.hellomvvm.bean.Person

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@Dao
interface IPersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg person: Person)

    @Delete
    suspend fun delete(vararg person: Person)

    @Query("DELETE FROM person")
    suspend fun deleteAll()

    @Update
    suspend fun update(vararg person: Person)

    @Query("SELECT * FROM person")
    suspend fun queryAll(): List<Person>

    @Query("SELECT * FROM person")
    fun queryAllObservable(): LiveData<MutableList<Person>>

    @Query("SELECT * FROM person WHERE name = :name")
    suspend fun queryAllByName(name: String): List<Person>

    @Query("SELECT * FROM person WHERE age = :age")
    suspend fun queryAllByAge(age: Int): List<Person>
}