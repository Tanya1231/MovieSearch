package com.example.moviesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.moviesearch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() {

        binding.buttonMenu.setOnClickListener {
            Toast.makeText(this, "МЕНЮ", Toast.LENGTH_SHORT).show()
        }

        binding.buttonFav.setOnClickListener {
            Toast.makeText(this, "ИЗБРАННОЕ", Toast.LENGTH_SHORT).show()
        }

        binding.buttonWatch.setOnClickListener {
            Toast.makeText(this, "ПОСМОТРЕТЬ ПОЗЖЕ", Toast.LENGTH_SHORT).show()
        }

        binding.buttonCompilations.setOnClickListener {
            Toast.makeText(this, "ПОДБОРКИ", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSettings.setOnClickListener {
            Toast.makeText(this, "НАСТРОЙКИ", Toast.LENGTH_SHORT).show()
        }
    }
}