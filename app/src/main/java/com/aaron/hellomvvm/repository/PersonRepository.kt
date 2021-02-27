package com.aaron.hellomvvm.repository

import androidx.lifecycle.LiveData
import com.aaron.hellomvvm.bean.Person
import com.aaron.hellomvvm.db.AppDatabase
import com.aaron.hellomvvm.db.IPersonDao

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
class PersonRepository {

    private val personDao: IPersonDao = AppDatabase.getPersonDao()

    suspend fun insert(vararg person: Person) {
        personDao.insert(*person)
    }

    suspend fun delete(vararg person: Person) {
        personDao.delete(*person)
    }

    suspend fun deleteAll() {
        personDao.deleteAll()
    }

    suspend fun update(vararg person: Person) {
        personDao.update(*person)
    }

    suspend fun queryAll(): List<Person> {
        return personDao.queryAll()
    }

    fun queryAllObservable(): LiveData<MutableList<Person>> {
        return personDao.queryAllObservable()
    }

    suspend fun queryAllByName(name: String): List<Person> {
        return personDao.queryAllByName(name)
    }

    suspend fun queryAllByAge(age: Int): List<Person> {
        return personDao.queryAllByAge(age)
    }
}