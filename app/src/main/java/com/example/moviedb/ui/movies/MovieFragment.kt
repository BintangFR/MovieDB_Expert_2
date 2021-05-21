package com.example.moviedb.ui.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.moviedb.core.domain.model.DataModels
import com.example.moviedb.core.interfaces.UserInterface
import com.example.moviedb.core.vo.Resource
import com.example.moviedb.databinding.FragmentMovieBinding
import com.example.moviedb.databinding.FragmentTVShowsBinding
import com.example.moviedb.ui.details.DetailsActivity
import org.koin.android.viewmodel.ext.android.viewModel


class MovieFragment : Fragment(), UserInterface {
    private var _binding: FragmentMovieBinding?= null
    private val binding: FragmentMovieBinding get() = _binding!!
    private lateinit var adapter: MovieAdapter
    private val viewModel: MovieViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMovieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            adapter = MovieAdapter(requireContext())
            adapter.userInterface = this
            binding.rvMovies.adapter = adapter

            viewModel.getMovies().observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            adapter.submitList(movie.data!!)
                            adapter.notifyDataSetChanged()
                        }
                        is Resource.Error -> {
                            showLoading(false)
                            Toast.makeText(context, "Loading Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }
    }

    override fun onUserClicked(view: View, dataModels: DataModels) {
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.ID, dataModels.id)
        intent.putExtra(DetailsActivity.CATEGORY, "Movies")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        requireActivity().startActivity(intent)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBarMovies.visibility = View.VISIBLE
            //binding.progressBarMovies.setProgress(100f)
            binding.rvMovies.visibility = View.GONE
        } else {
            binding.progressBarMovies.visibility = View.GONE
            binding.rvMovies.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        binding.rvMovies.adapter = null
        _binding = null

        super.onDestroyView()
    }

}