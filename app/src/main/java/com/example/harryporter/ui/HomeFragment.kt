@file:Suppress("UNREACHABLE_CODE")

package com.example.harryporter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.harryporter.adapter.CharacterAdapter
import com.example.harryporter.databinding.FragmentHomeBinding
import com.example.harryporter.network.HarryApi
import com.example.harryporter.repo.MainReporsitory
import com.example.harryporter.viewmodel.HarryViewModel
import com.example.harryporter.viewmodel.MyViewModelFactory


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: HarryViewModel
    private lateinit var harryAdapter: CharacterAdapter
    private val retrofitService = HarryApi.getInstance()
    private val mainRepository = MainReporsitory(retrofitService)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        viewModel =ViewModelProvider(this, MyViewModelFactory(mainRepository))[HarryViewModel::class.java]
        viewModel.harryList.observe(viewLifecycleOwner) {
            harryAdapter.differ.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            harryAdapter = CharacterAdapter()
            adapter = harryAdapter



        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}