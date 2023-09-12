package com.akkobana.rickandmortyapp.presentation.adapters.filter

import androidx.core.view.isVisible
import com.akkobana.rickandmortyapp.databinding.ItemCategoryFilterBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder
import com.akkobana.rickandmortyapp.presentation.adapters.allfilters.AllFiltersAdapter

class FilterGenderViewHolder(
    private val binding: ItemCategoryFilterBinding,
    private val filterValueCallback: (String) -> Unit
) : BaseViewHolder(binding) {

    private var isVisible = false

    fun bind(item: String, filterEntity: List<String>) = with(binding) {
        tvFilterCategory.text = item
        itemView.setOnClickListener {
            isVisible = !isVisible
            rvFilter.isVisible = isVisible
        }
        initAdapter(filterEntity)
    }

    private fun initAdapter(filterEntity: List<String>) {

        val adapter = AllFiltersAdapter(filterEntity, FilterAdapter.ViewType.GENDER_FILTER) {
            filterValueCallback.invoke(it)
        }
        binding.rvFilter.adapter = adapter
    }

}