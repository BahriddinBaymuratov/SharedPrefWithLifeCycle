package com.example.activitylifecycle

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("onCreate ishga tushdi")
        log("onCreate ishga tushdi")

        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
            startActivity(Intent(this,SecondActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        toast("onStart ishga tushdi")
        log("onStart ishga tushdi")
    }

    override fun onResume() {
        super.onResume()
        toast("onResume ishga tushdi")
        log("onResume ishga tushdi")
    }

    override fun onPause() {
        super.onPause()
        toast("onPause ishga tushdi")
        log("onPause ishga tushdi")
    }

    override fun onStop() {
        super.onStop()
        toast("onStop ishga tushdi")
        log("onStop ishga tushdi")
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("onDestroy ishga tushdi")
        log("onDestroy ishga tushdi")
    }

    override fun onRestart() {
        super.onRestart()
        toast("onRestart ishga tushdi")
        log("onRestart ishga tushdi")
    }
    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
    private fun log(msg: String) {
        Log.d("MainActivity@@", msg)
    }

}