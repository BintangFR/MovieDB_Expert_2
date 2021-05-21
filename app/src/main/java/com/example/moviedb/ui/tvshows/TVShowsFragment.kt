package com.example.moviedb.ui.tvshows

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
import com.example.moviedb.databinding.FragmentTVShowsBinding
import com.example.moviedb.ui.details.DetailsActivity
import org.koin.android.viewmodel.ext.android.viewModel


class TVShowsFragment : Fragment(), UserInterface {
    private lateinit var binding: FragmentTVShowsBinding
    private lateinit var adapter: TVShowsAdapter
    private val viewModel: TVShowsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTVShowsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            adapter = TVShowsAdapter(requireContext())
            adapter.userInterface = this
            binding.rvTVShows.adapter = adapter
            viewModel.getTVShows().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    when (tvShow) {
                        is Resource.Loading -> showLoading(true)
                        is Resource.Success -> {
                            showLoading(false)
                            adapter.submitList(tvShow.data!!)
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
        intent.putExtra(DetailsActivity.CATEGORY, "TV Shows")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        requireActivity().startActivity(intent)
    }

    private fun showLoading(state: Boolean) {
        if (state) {
            binding.progressBarTvShows.visibility = View.VISIBLE
            binding.progressBarTvShows.setProgress(100f)
            binding.rvTVShows.visibility = View.GONE
        } else {
            binding.progressBarTvShows.visibility = View.GONE
            binding.rvTVShows.visibility = View.VISIBLE
        }
    }
}