package com.aaron.hellomvvm.utils

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.toDrawable
import com.aaron.hellomvvm.R
import com.aaron.hellomvvm.bean.Gender
import com.aaron.hellomvvm.bean.Person
import kotlin.random.Random

/**
 * @author aaronzzxup@gmail.com
 * @since 2021/2/26
 */
object PersonRandomUtils {

    private val NAMES = listOf(
        "Aaron", "Michael", "James", "Kobe",
        "Mickey", "Tina", "Gordan", "Rose",
        "Diana", "Davis", "Louis", "Parker",
        "Lunar", "Arthur", "Jordan", "Paul",
        "狗蛋", "狗剩", "小明", "小红",
        "翠花", "大锤", "铁锤", "二狗"
    )

    private val colors = listOf(
        R.color.purple_200.color,
        R.color.purple_500.color,
        R.color.purple_700.color,
        R.color.teal_200.color,
        R.color.teal_700.color,
        R.color.black.color
    )

    fun randomPerson(): Person {
        return Person(randomName(), randomAge(), randomGender())
    }

    fun randomName(): String {
        return NAMES.random(Random(System.currentTimeMillis()))
    }

    fun randomAge(): Int {
        val random = Random(System.currentTimeMillis())
        return random.nextInt(1, 100)
    }

    fun randomGender(): Gender {
        val random = Random(System.currentTimeMillis())
        return Gender.values().random(random)
    }

    fun randomBackground(seed: Long = System.currentTimeMillis()): Drawable {
        return colors.random(Random(seed)).toDrawable()
    }
}