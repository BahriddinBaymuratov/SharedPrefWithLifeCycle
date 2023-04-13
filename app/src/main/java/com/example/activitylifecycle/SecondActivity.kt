package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var counter: Button
    private lateinit var textView: TextView
    private lateinit var clear: Button
    private var count = 0
    private val sharedPref by lazy { SharedPrefManager(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.text5)
        counter = findViewById(R.id.count)
        clear = findViewById(R.id.clear)

        textView.text = sharedPref.getCount().toString()
        count = sharedPref.getCount() // 17

        counter.setOnClickListener {
            count++
            textView.text = count.toString()
            sharedPref.counter(count)
        }
        clear.setOnClickListener {
            sharedPref.clear()
            textView.text = "0"
            count = 0
        }
    }
}