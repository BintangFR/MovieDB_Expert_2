package com.example.moviedb.ui.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedb.BuildConfig.IMAGE_URL
import com.example.moviedb.core.data.local.entity.DataEntity
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.interfaces.UserInterface
import com.example.moviedb.databinding.ItemMoviesBinding

class MovieAdapter(private val context: Context) :
    ListAdapter<DataModels, MovieAdapter.ViewHolder>(DiffCallback()) {
    var userInterface: UserInterface? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        context
    )

    inner class ViewHolder(private val binding: ItemMoviesBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataModels: DataModels, userInterface: UserInterface?) {
            Glide.with(binding.root).load("$IMAGE_URL${dataModels.poster}").into(binding.ivPoster)
            binding.apply {
                tvTitle.text = dataModels.title
                tvYears.text = dataModels.releaseDate?.substring(0..3)
                tvRating.text = dataModels.score.toString()

                clItems.setOnClickListener {
                    userInterface?.onUserClicked(root, dataModels)
                }
            }
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie, userInterface)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<DataModels>() {
        override fun areItemsTheSame(oldItem: DataModels, newItem: DataModels): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: DataModels, newItem: DataModels): Boolean =
            oldItem.title == newItem.title
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataEntity>() {
            override fun areItemsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: DataEntity, newItem: DataEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

}