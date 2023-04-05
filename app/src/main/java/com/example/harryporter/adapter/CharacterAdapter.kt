package com.example.harryporter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harryporter.data.HarryItem
import com.example.harryporter.databinding.CharacterBinding

class CharacterAdapter (private val onItemClicked: (HarryItem) -> Unit): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    inner class CharacterViewHolder(val binding: CharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    private val diffCallBack = object : DiffUtil.ItemCallback<HarryItem>() {
        override fun areItemsTheSame(oldItem: HarryItem, newItem: HarryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HarryItem, newItem: HarryItem): Boolean {
            return oldItem == newItem
        }
    }
    public val differ = AsyncListDiffer(this, diffCallBack)
    var harrys: List<HarryItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            CharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount() = harrys.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val harry = harrys[position]
        holder.binding.apply {
            homeName.text = harry.name
            Glide.with(holder.itemView).load(harry.image).into(homeImage)
            root.setOnClickListener {
                onItemClicked(harry)
            }

        }
    }


}