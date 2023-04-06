package com.example.harryporter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.harryporter.data.HarryItem
import com.example.harryporter.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()
    val character = args.character


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!




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
        binding.apply {
            binding.actualAncestry.text=character.ancestry
            binding.homeName.text=character.name
            binding.actualSpecies.text=character.species
            binding.actualGender.text=character.gender
            binding.dob.text=character.dateOfBirth
            binding.yob.text=character.yearOfBirth.toString()
            binding.aliveStatus.text= character.alive.toString()
            binding.actualEyeColor.text=character.eyeColour
            binding.actualWand.text=character.wand.length.toString()



        }
    }



}