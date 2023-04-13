package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.annotation.ColorRes
import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class SharedPref : AppCompatActivity() {
    private lateinit var constraintLayout: ConstraintLayout
    private val sharedPref by lazy { SharedPrefManager(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        constraintLayout = findViewById(R.id.constraintLayout)

        changeBackColor(getColorFun(sharedPref.getColor()))
        radioGroup.check(checkId(sharedPref.getColor()))

        radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.red -> {
                    sharedPref.saveColor(0)
                    changeBackColor(R.color.red)
                }
                R.id.blue -> {
                    sharedPref.saveColor(1)
                    changeBackColor(R.color.blue)
                }
                R.id.green -> {
                    sharedPref.saveColor(2)
                    changeBackColor(R.color.green)
                }
                R.id.yellow -> {
                    sharedPref.saveColor(3)
                    changeBackColor(R.color.yellow)
                }
                R.id.gray -> {
                    sharedPref.saveColor(4)
                    changeBackColor(R.color.gray)
                }
            }
        }
    }

    @ColorRes
    private fun getColorFun(int: Int): Int {
        return when (int) {
            0 -> R.color.red
            1 -> R.color.blue
            2 -> R.color.green
            3 -> R.color.yellow
            4 -> R.color.gray
            else -> R.color.red
        }
    }

    @IdRes
    private fun checkId(int: Int): Int {
        return when(int) {
            0 -> R.id.red
            1 -> R.id.blue
            2 -> R.id.green
            3 -> R.id.yellow
            4 -> R.id.gray
            else -> R.id.red
        }
    }

    private fun changeBackColor(@ColorRes color: Int) {
        constraintLayout.setBackgroundColor(ContextCompat.getColor(this, color))
    }
}