package com.example.harryporter.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.harryporter.R
import com.example.harryporter.adapter.CharacterAdapter
import com.example.harryporter.data.HarryItem
import com.example.harryporter.databinding.FragmentDetailBinding
import com.example.harryporter.databinding.FragmentHomeBinding
import com.example.harryporter.network.RetrofitInstance
import com.example.harryporter.repo.MainReporsitory
import com.example.harryporter.viewmodel.HarryViewModel
import com.example.harryporter.viewmodel.MyViewModelFactory


class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HarryViewModel
//    private val retrofitService = RetrofitInstance.api
//    private val mainRepository = MainReporsitory(retrofitService)
//    private lateinit var harryAdapter: CharacterAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)



        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addHarryDetails()
    }




    private fun addHarryDetails() {
        var mQuestions: MutableList<HarryItem> = ArrayList()



        binding.apply {
            binding.actualAncestry.text=mPreviousWho

        }
    }



}