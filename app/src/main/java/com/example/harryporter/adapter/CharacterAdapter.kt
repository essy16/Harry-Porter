package com.example.harryporter.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.harryporter.R
import com.example.harryporter.data.HarryItem
import com.example.harryporter.databinding.CharacterBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    inner class CharacterViewHolder(binding: CharacterBinding) :
        RecyclerView.ViewHolder(binding.root)
        private val diffCallBack = object : DiffUtil.ItemCallback<HarryItem>() {
            override fun areItemsTheSame(oldItem: HarryItem, newItem: HarryItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: HarryItem, newItem: HarryItem): Boolean {
                return oldItem == newItem
            }
        }
        private val difer=AsyncListDiffer(this,diffCallBack)
    var harrys= List<HarryItem>()




}