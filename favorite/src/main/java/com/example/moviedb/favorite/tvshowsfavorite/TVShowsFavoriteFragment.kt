package com.example.moviedb.favorite.tvshowsfavorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.interfaces.UserInterface
import com.example.moviedb.favorite.databinding.FragmentTVShowsFavoriteBinding
import com.example.moviedb.ui.details.DetailsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class TVShowsFavoriteFragment : Fragment(), UserInterface {
    private lateinit var binding: FragmentTVShowsFavoriteBinding
    private lateinit var adapter: TVShowsFavoriteAdapter
    private val viewModel: TVShowsFavoriteViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTVShowsFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TVShowsFavoriteAdapter(requireContext())
        adapter.userInterface = this
        binding.rvTVShowsFavorite.adapter = adapter
        viewModel.getFavoriteTv().observe(viewLifecycleOwner, { tvShow ->
            adapter.submitList(tvShow)
            adapter.notifyDataSetChanged()
        })

    }

    override fun onUserClicked(view: View, dataModels: DataModels) {
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.ID, dataModels.id)
        intent.putExtra(DetailsActivity.CATEGORY, "TV Shows")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        requireActivity().startActivity(intent)
    }
}