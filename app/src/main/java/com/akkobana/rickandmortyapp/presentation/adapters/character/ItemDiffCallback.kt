package com.akkobana.rickandmortyapp.presentation.adapters.character

import androidx.recyclerview.widget.DiffUtil

class ItemDiffCallback(private val oldItems: List<Any>, private val newItems: List<Any>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].hashCode() == newItems[newItemPosition].hashCode()
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}