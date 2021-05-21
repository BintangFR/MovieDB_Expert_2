package com.example.moviedb.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviedb.favorite.databinding.ActivityFavoriteHomeBinding
import com.example.moviedb.favorite.di.favoriteModule
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.core.context.loadKoinModules

class FavoriteHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteHomeBinding
    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        adapter = FavoriteAdapter(this)
        binding.viewPagerDetails.adapter = adapter
        binding.viewPagerDetails.offscreenPageLimit = adapter.itemCount

        TabLayoutMediator(
            binding.tabLayoutDetails,
            binding.viewPagerDetails
        ) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.favorite_movie)
                1 -> tab.text = getString(R.string.favorite_tv)
            }
        }.attach()
    }


}