package com.example.moviesearch

import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.databinding.FilmItemBinding


//В конструктор класс передается layout, который мы создали(film_item.xml)
class FilmViewHolder(private var binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description

    //В этом методе кладем данные из film в наши view
    fun bind(film: Film) {
        //Устанавливаем заголовок
        title.text = film.title
        //Устанавливаем постер
        poster.setImageResource(film.poster)
        //Устанавливаем описание
        description.text = film.description
    }
}