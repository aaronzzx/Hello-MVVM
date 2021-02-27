package com.aaron.hellomvvm.viewmodel

import android.app.Application
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.aaron.hellomvvm.bean.Person
import com.aaron.hellomvvm.repository.PersonRepository
import com.aaron.hellomvvm.utils.PersonRandomUtils
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.launch

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@ActivityRetainedScoped
class MainViewModel @ViewModelInject constructor(
    app: Application,
    private val personRepository: PersonRepository
) : AndroidViewModel(app) {

    val person = Transformations.map(personRepository.queryAllObservable()) {
        it
    }

    init {
        viewModelScope.launch {
            if (personRepository.queryAll().isEmpty().not()) {
                return@launch
            }
            repeat(20) {
                val random = PersonRandomUtils.randomPerson()
                val person = Person(random.name, random.age, random.gender)
                personRepository.insert(person)
            }
        }
    }

    fun add(vararg person: Person) = viewModelScope.launch {
        personRepository.insert(*person)
    }

    fun delete(vararg person: Person) = viewModelScope.launch {
        personRepository.delete(*person)
    }

    fun deleteAll() = viewModelScope.launch {
        personRepository.deleteAll()
    }
}