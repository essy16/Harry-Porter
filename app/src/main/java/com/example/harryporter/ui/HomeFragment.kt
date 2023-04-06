@file:Suppress("UNREACHABLE_CODE")

package com.example.harryporter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.harryporter.adapter.CharacterAdapter
import com.example.harryporter.data.HarryItem
import com.example.harryporter.databinding.FragmentHomeBinding
import com.example.harryporter.network.RetrofitInstance
import com.example.harryporter.repo.MainRepository
import com.example.harryporter.viewmodel.HarryViewModel
import com.example.harryporter.viewmodel.MyViewModelFactory
import java.util.*


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private lateinit var characterList: List<HarryItem>
    private val binding get() = _binding!!
    private lateinit var viewModel: HarryViewModel
    private lateinit var harryAdapter: CharacterAdapter
    private val retrofitService = RetrofitInstance.api
    private val mainRepository = MainRepository(retrofitService)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(mainRepository))[HarryViewModel::class.java]
        viewModel.harryList.observe(viewLifecycleOwner) {
            harryAdapter.differ.submitList(it)
            characterList=it

        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        harryAdapter = CharacterAdapter {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            findNavController().navigate(action)

        }
        setUpRecyclerView()

        onHarrySearch()
    }

    private fun setUpRecyclerView() {
        binding.recyclerView.apply {

            adapter = harryAdapter
        }

    }


    private fun onHarrySearch() {
        binding.svCharacters.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (this@HomeFragment::characterList.isInitialized) {
                        val searchResults = viewModel.searchCharacter(characterList, query!!)
                        harryAdapter.differ.submitList(null)
                        harryAdapter.differ.submitList(searchResults)}
                        return false
                    }


                override fun onQueryTextChange(newText: String?): Boolean {
                    if (this@HomeFragment::characterList.isInitialized) {

                        val searchResults =
                        viewModel.searchCharacter(
                            characterList,
                            newText!!
                        )

                    harryAdapter.differ.submitList(null)
                    harryAdapter.differ.submitList(searchResults)}
                    return true
                }
            })


        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}