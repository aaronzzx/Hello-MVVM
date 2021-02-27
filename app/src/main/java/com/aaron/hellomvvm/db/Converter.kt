package com.aaron.hellomvvm.db

import androidx.room.TypeConverter
import com.aaron.hellomvvm.bean.Gender

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/27
 */
class Converter {

    @TypeConverter
    fun fromGender(gender: Gender?): String? {
        return gender?.name
    }

    @TypeConverter
    fun toGender(gender: String?): Gender? {
        return Gender.valueOf(gender ?: return null)
    }
}