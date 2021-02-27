package com.aaron.hellomvvm.bean

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/25
 */
@Entity
class Person(var name: String, var age: Int, var gender: Gender) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L

    var seed: Long = System.currentTimeMillis()
}