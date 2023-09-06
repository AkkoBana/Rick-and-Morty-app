package com.akkobana.rickandmortyapp.presentation.adapters.filter

import android.util.Log
import androidx.core.view.isVisible
import com.akkobana.rickandmortyapp.data.model.FilterEntity
import com.akkobana.rickandmortyapp.databinding.ItemCategoryFilterBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder
import com.akkobana.rickandmortyapp.presentation.adapters.allfilters.AllFiltersAdapter

class FilterGenderViewHolder(
    private val binding: ItemCategoryFilterBinding,
    private val callback: (String) -> Unit
) : BaseViewHolder(binding) {

    private var isVisible = false

    fun bind(item: String, filterEntity: List<String>) = with(binding) {
        Log.d("MyLog", item)
        tvFilterCategory.text = item
        itemView.setOnClickListener {
            isVisible = !isVisible
            rvFilter.isVisible = isVisible
        }
        initAdapter(filterEntity)
    }

    private fun initAdapter(filterEntity: List<String>) {

        val adapter = AllFiltersAdapter(filterEntity, FilterAdapter.ViewType.GENDER_FILTER)
        binding.rvFilter.adapter = adapter
    }

}