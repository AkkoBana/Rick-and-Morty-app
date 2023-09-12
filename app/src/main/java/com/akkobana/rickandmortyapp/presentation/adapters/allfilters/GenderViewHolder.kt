package com.akkobana.rickandmortyapp.presentation.adapters.allfilters

import com.akkobana.rickandmortyapp.databinding.ItemFiltersBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class GenderViewHolder(
    private val binding: ItemFiltersBinding,
    private val isCheckedCallback: (Int) -> Unit,
    private val filterValueCallback: (String) -> Unit
) : BaseViewHolder(binding) {

    fun bind(item: String) = with(binding) {
        tvFilterName.text = item
        cbFilter.isChecked = false
        cbFilter.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) isCheckedCallback.invoke(layoutPosition)
            filterValueCallback.invoke(tvFilterName.text.toString())
        }
    }
}