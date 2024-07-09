package com.example.moviesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.moviesearch.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_placeholder, HomeFragment())
            .addToBackStack(null)
            .commit()

        initNavigation()

        initToolbar()

        switch()
    }

    fun launchDetailsFragment(film: Film) {
        val bundle = Bundle()

        bundle.putParcelable("film", film)

        val fragment = DetailsFragment()

        fragment.arguments = bundle

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_placeholder, fragment)
            .addToBackStack(null)
            .commit()

    }


    private fun initNavigation() {
        val snackbarFavourites =
            Snackbar.make(binding.bottomNavigation, "Избранное", Snackbar.LENGTH_SHORT)
        val snackbarLater =
            Snackbar.make(binding.bottomNavigation, "Посмотреть позже", Snackbar.LENGTH_SHORT)
        val snackbarSelections =
            Snackbar.make(binding.bottomNavigation, "Подборки", Snackbar.LENGTH_SHORT)
        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    snackbarFavourites.show()
                    true
                }

                R.id.watch_later -> {
                    snackbarLater.show()
                    true
                }

                R.id.selections -> {
                    snackbarSelections.show()
                    true
                }

                else -> false
            }
        }
    }

    private fun initToolbar() {
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, "Настройки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }

    private fun switch() {
        val btn = findViewById<SwitchMaterial>(R.id.switchOne)

        btn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
            } else {
                delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
            }
        }
    }
}