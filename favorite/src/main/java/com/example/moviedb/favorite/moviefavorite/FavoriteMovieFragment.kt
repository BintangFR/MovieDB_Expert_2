package com.example.moviedb.favorite.moviefavorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.interfaces.UserInterface
import com.example.moviedb.favorite.databinding.FragmentFavoriteMovieBinding
import com.example.moviedb.ui.details.DetailsActivity
import org.koin.android.viewmodel.ext.android.viewModel

class FavoriteMovieFragment : Fragment(), UserInterface {
    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var adapter: FavoriteMovieAdapter
    private val viewModel: FavoriteMovieViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteMovieAdapter(requireContext())
        adapter.userInterface = this
        binding.rvMoviesFavorite.adapter = adapter

        viewModel.getFavoriteMovie().observe(viewLifecycleOwner, { movie ->
            adapter.submitList(movie)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onUserClicked(view: View, dataModels: DataModels) {
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.ID, dataModels.id)
        intent.putExtra(DetailsActivity.CATEGORY, "Movies")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        requireActivity().startActivity(intent)
    }


}