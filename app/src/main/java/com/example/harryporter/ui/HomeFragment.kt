@file:Suppress("UNREACHABLE_CODE")

package com.example.harryporter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.harryporter.adapter.CharacterAdapter
import com.example.harryporter.databinding.FragmentHomeBinding
import com.example.harryporter.network.HarryApi
import com.example.harryporter.network.RetrofitInstance
import com.example.harryporter.repo.MainReporsitory
import com.example.harryporter.viewmodel.HarryViewModel
import com.example.harryporter.viewmodel.MyViewModelFactory
import kotlinx.coroutines.withContext


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: HarryViewModel
    private lateinit var harryAdapter: CharacterAdapter
    private val retrofitService = RetrofitInstance.api
    private val mainRepository = MainReporsitory(retrofitService)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(mainRepository))[HarryViewModel::class.java]
        viewModel.harryList.observe(viewLifecycleOwner) { it ->
            harryAdapter.differ.submitList(it)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {
            harryAdapter = CharacterAdapter{
                val action=HomeFragmentDirections.actionHomeFragmentToDetailFragment()
                findNavController().navigate(action)

            }
            adapter = harryAdapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}