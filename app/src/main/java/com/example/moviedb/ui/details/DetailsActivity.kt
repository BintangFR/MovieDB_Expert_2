package com.example.moviedb.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.moviedb.BuildConfig.IMAGE_URL
import com.example.moviedb.R
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.vo.Resource
import com.example.moviedb.databinding.ActivityDetailsBinding
import com.example.moviedb.databinding.FragmentMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private var _binding: ActivityDetailsBinding?= null
    private val binding: ActivityDetailsBinding get() = _binding!!
    private lateinit var dataModels: DataModels
    private val viewModel: DetailsViewModel by viewModel()
    private var isFavorite = false

    companion object {
        const val ID = "id"
        var CATEGORY = "category"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val extras = intent.extras
        if (extras != null) {
            val film = extras.getInt(ID)
            when (extras?.getString(CATEGORY)) {
                "Movies" -> viewModel.getMovie(film).observe(this, { result ->
                    when (result) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            if (result.data != null) {
                                showLoading(false)
                                loadData(result.data!!)
                                isFavorite = result.data!!.favorite
                            }
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(this, "Loading Failed", Toast.LENGTH_SHORT).show()
                        }

                    }

                })
                "TV Shows" -> viewModel.getTv(film).observe(this, { result ->
                    when (result) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            if (result.data != null) {
                                showLoading(false)
                                loadData(result.data!!)
                                isFavorite = result.data!!.favorite
                            }
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(this, "Loading Failed", Toast.LENGTH_SHORT).show()
                        }

                    }
                })
            }

        }
    }

    private fun loadData(dataModels: DataModels) {

        Glide.with(binding.root).load("$IMAGE_URL${dataModels.poster}")
            .into(binding.kenburnsBackground)
        binding.apply {
            tvTitle.text = dataModels.title
            tvReleaseDate.text = dataModels.releaseDate
            tvRating.text = dataModels.score.toString()
            tvDescription.text = dataModels.overview
            tvGenre.text = dataModels.genre
        }
        this.dataModels = dataModels
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.actionbar_details, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_share) {
            shareContent()
        }
        if (item.itemId == R.id.action_addFavorite) {
            viewModel.setFavorite(dataModels)
            isFavorite = !isFavorite
            changeFavlogo(item)
            if (isFavorite) Toast.makeText(
                this@DetailsActivity,
                "Added to favorite",
                Toast.LENGTH_SHORT
            ).show()
            else Toast.makeText(this@DetailsActivity, "Removed from favorite", Toast.LENGTH_SHORT)
                .show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun shareContent() {
        val textSend = """
            ${StringBuilder("${checkNull(dataModels.title, getString(R.string.Title))}")}
         ${StringBuilder("${checkNull(dataModels.releaseDate, getString(R.string.ReleaseDate))}")}
         ${StringBuilder("${checkNull(dataModels.genre, getString(R.string.Genre))}")}
        """.trimIndent()
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, textSend)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    private fun checkNull(item: String?, data: String): CharSequence {
        return when (item) {
            null -> String.format("No %s", data)
            else -> item
        }
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBarDetails.visibility = View.VISIBLE
        } else {
            binding.progressBarDetails.visibility = View.GONE
        }
    }

    private fun changeFavlogo(item: MenuItem) {
        if (isFavorite) {
            item.icon = getDrawable(R.drawable.ic_baseline_favorite_24)
        } else {
            item.icon = getDrawable(R.drawable.ic_baseline_favorite_border_24)
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }



}