package com.ammar.reqressapp.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ammar.reqressapp.R
import com.ammar.reqressapp.data.viewmodel.HomeViewModel
import com.ammar.reqressapp.databinding.FragmentHomeBinding
import com.ammar.reqressapp.view.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    @FragmentScoped
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter

    private val viewModel : HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRV()
    }

    private fun setRV() {
        homeAdapter = HomeAdapter()
        binding.rvMain.apply {
            adapter = homeAdapter
            layoutManager = LinearLayoutManager(activity)
            setHasFixedSize(true)
        }
        viewModel.userResponse.observe(requireActivity(), { result ->
            homeAdapter.dataUser = result.data
        })
    }
}