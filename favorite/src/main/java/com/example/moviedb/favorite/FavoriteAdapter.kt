package com.example.moviedb.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviedb.favorite.moviefavorite.FavoriteMovieFragment
import com.example.moviedb.favorite.tvshowsfavorite.TVShowsFavoriteFragment

class FavoriteAdapter(private val activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FavoriteMovieFragment()
            1 -> TVShowsFavoriteFragment()
            else -> FavoriteMovieFragment()
        }
    }


}