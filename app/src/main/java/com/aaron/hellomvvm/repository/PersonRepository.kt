package com.aaron.hellomvvm.repository

import com.aaron.hellomvvm.db.IPersonDao
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@Singleton
class PersonRepository @Inject constructor(private val dao: IPersonDao) : IPersonDao by dao