package com.akkobana.rickandmortyapp.presentation.adapters.allfilters

import com.akkobana.rickandmortyapp.databinding.ItemFiltersBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class StatusViewHolder(
    private val binding: ItemFiltersBinding
) : BaseViewHolder(binding) {

    fun bind(item: String) = with(binding) {
        tvFilterName.text = item
    }
}