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
import com.example.harryporter.viewmodel.HarryViewModel


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: HarryViewModel
    private lateinit var harryAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
        viewModel = ViewModelProvider(this)[HarryViewModel::class.java]
        viewModel.getHarrys()
        viewModel.observeHarryLiveData().observe(this.viewLifecycleOwner) { }
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