package com.aaron.hellomvvm.di

import com.aaron.hellomvvm.db.AppDatabase
import com.aaron.hellomvvm.db.IPersonDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/27
 */
@Module
@InstallIn(ApplicationComponent::class)
class PersonDaoModule {

    @Singleton
    @Provides
    fun providePersonDao(): IPersonDao {
        return AppDatabase.getPersonDao()
    }
}