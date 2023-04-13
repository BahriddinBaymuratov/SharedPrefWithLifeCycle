package com.example.activitylifecycle

import android.content.Context
import android.content.SharedPreferences

class SharedPrefManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyPref2", Context.MODE_PRIVATE)

    fun saveColor(int: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("color", int)
        editor.apply()
    }

    fun getColor(): Int {
        return sharedPreferences.getInt("color", -1)
    }

    fun counter(int: Int) {
        val edit = sharedPreferences.edit()
        edit.putInt("count", int)
        edit.apply()
    }

    fun getCount(): Int {
        return sharedPreferences.getInt("count", 0)
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}