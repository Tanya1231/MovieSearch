package com.example.moviesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.ViewGroup

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val content = findViewById<ViewGroup>(R.id.content)
    }
}