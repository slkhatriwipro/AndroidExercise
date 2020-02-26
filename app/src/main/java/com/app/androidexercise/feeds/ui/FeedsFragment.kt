package com.app.androidexercise.feeds.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.androidexercise.databinding.FragmentFeedsBinding
import com.app.androidexercise.db.Result
import com.app.androidexercise.di.Injectable
import com.app.androidexercise.di.injectViewModel
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class FeedsFragment : Fragment(), Injectable {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: FeedsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = FragmentFeedsBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = FeedsAdapter()
        binding.recyclerView.adapter = adapter

        subscribeFeedsUi(binding, adapter)

        //setHasOptionsMenu(true)
        return binding.root
    }

    private fun subscribeFeedsUi(binding: FragmentFeedsBinding, adapter: FeedsAdapter) {
        viewModel.feedsResult.observe(viewLifecycleOwner, Observer { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    result.data?.let { adapter.submitList(it) }
                }
                Result.Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                Result.Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Snackbar.make(binding.root, result.message!!, Snackbar.LENGTH_LONG).show()
                }
            }
        })
    }
}