package com.akkobana.rickandmortyapp.presentation.adapters.allfilters

import android.util.Log
import com.akkobana.rickandmortyapp.databinding.ItemFiltersBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class GenderViewHolder(
    private val binding: ItemFiltersBinding,
    private val callback: (Int) -> Unit
) : BaseViewHolder(binding) {

    fun bind(item: String, position: Int?) = with(binding) {
        tvFilterName.text = item
        if(layoutPosition == position) {
            cbFilter.isChecked = false
        }
        cbFilter.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) callback.invoke(layoutPosition)
        }
    }
}