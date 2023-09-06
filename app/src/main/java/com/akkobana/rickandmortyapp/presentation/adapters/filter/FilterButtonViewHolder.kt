package com.akkobana.rickandmortyapp.presentation.adapters.filter

import androidx.recyclerview.widget.RecyclerView
import com.akkobana.rickandmortyapp.databinding.ItemFilterButtonsBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class FilterButtonViewHolder(
    private val binding: ItemFilterButtonsBinding
): BaseViewHolder(binding) {

    fun bind(item: String) = with(binding){
        bSave.setOnClickListener {

        }
        bClear.setOnClickListener {

        }
    }
}