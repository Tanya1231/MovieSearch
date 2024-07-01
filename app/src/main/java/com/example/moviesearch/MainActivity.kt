package com.example.moviesearch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.moviesearch.databinding.ActivityMainBinding
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigation()

        initToolbar()

        switch()

    }

    fun initNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, "Избранное", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.watch_later -> {
                    Toast.makeText(this, "Посмотреть позже", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.selections -> {
                    Toast.makeText(this, "Подборки", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }

    fun initToolbar() {
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

    // База с фильмами
    data class Film(
        val title: String,
        val poster: Int,
        val description: String
    )

    val filmsDataBase = listOf(
        Film(
            title = "Начало",
            poster = R.drawable.beginning,
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O., but his tragic past may doom the project and his team to disaster."
        ),
        Film(
            title = "Интерстеллар",
            poster = R.drawable.interstellar,
            description = "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans."
        ),
        Film(
            title = "Паразиты",
            poster = R.drawable.parasites,
            description = "Greed and class discrimination threaten the newly-formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."
        ),
        Film(
            title = "Отступники",
            poster = R.drawable.otstupniki,
            description = "An undercover cop and a mole in the police attempt to identify each other while infiltrating an Irish gang in South Boston."
        ),
        Film(
            title = "Джанго освобожденный",
            poster = R.drawable.django,
            description = "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation owner in Mississippi."
        ),
        Film(
            title = "ВАЛЛ·И",
            poster = R.drawable.valley,
            description = "In the distant future, a small waste-collecting robot inadvertently embarks on a space journey that will ultimately decide the fate of mankind."
        ),
        Film(
            title = "Бесславные ублюдки",
            poster = R.drawable.lnglorious_bastards,
            description = "In Nazi-occupied France during World War II, a plan to assassinate Nazi leaders by a group of Jewish U.S. soldiers coincides with a theatre owner's vengeful plans for the same."
        ),
        Film(
            title = "Вверх",
            poster = R.drawable.up,
            description = "78-year-old Carl Fredricksen travels to Paradise Falls in his house equipped with balloons, inadvertently taking a young stowaway."
        ),
        Film(
            title = "Зеленая книга",
            poster = R.drawable.the_green_book,
            description = "A working-class Italian-American bouncer becomes the driver for an African-American classical pianist on a tour of venues through the 1960s American South."
        ),
        Film(
            title = "Кремниевая долина",
            poster = R.drawable.kremnievaya_dolina,
            description = "Follows the struggle of Richard Hendricks, a Silicon Valley engineer trying to build his own company called Pied Piper."
        ),
    )
}