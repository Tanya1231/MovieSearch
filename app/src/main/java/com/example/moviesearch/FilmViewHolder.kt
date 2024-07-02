package com.example.moviesearch

import androidx.recyclerview.widget.RecyclerView
import com.example.moviesearch.databinding.FilmItemBinding

//В конструктор класс передается layout, который мы создали(film_item.xml)

class FilmViewHolder(binding: FilmItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private val title = binding.title
    private val poster = binding.poster
    private val description = binding.description

    fun bind(film: Film) {
        title.text = film.title
        poster.setImageResource(film.poster)
        description.text = film.description
    }
}