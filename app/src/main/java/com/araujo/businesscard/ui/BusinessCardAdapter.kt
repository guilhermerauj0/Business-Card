package com.araujo.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.araujo.businesscard.data.BusinessCard
import com.araujo.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter : ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (
        private val binding: ItemBusinessCardBinding
        ) : RecyclerView.ViewHolder(binding.root){
            fun bind(item: BusinessCard){
                binding.tvName.text = item.name
                binding.tvEmail.text = item.email
                binding.tvPhone.text = item.phone
                binding.tvEnterprise.text = item.enterprise
                binding.mcvContent.setBackgroundColor(Color.parseColor(item.background))
                binding.mcvContent.setOnClickListener {
                    listenerShare(it)
                }
            }
        }

    var listenerShare : (View) -> Unit = {}

}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>(){
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) = oldItem.id == newItem.id

}