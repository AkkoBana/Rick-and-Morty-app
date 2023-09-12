package com.akkobana.rickandmortyapp.presentation.adapters.filter

import com.akkobana.rickandmortyapp.databinding.ItemFilterButtonsBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class FilterButtonViewHolder(
    private val binding: ItemFilterButtonsBinding,
    private val callback: (Boolean) -> Unit
): BaseViewHolder(binding) {

    fun bind() = with(binding){
        bSave.setOnClickListener {
            callback.invoke(true)
        }
        bCancel.setOnClickListener {
            callback.invoke(false)
        }
    }

}