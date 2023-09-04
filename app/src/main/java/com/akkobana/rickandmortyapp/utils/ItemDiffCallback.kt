package com.akkobana.rickandmortyapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.akkobana.rickandmortyapp.data.model.CharacterCard

class ItemDiffCallback(private val oldItems: List<CharacterCard>, private val newItems: List<CharacterCard>) :
    DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldItems.size
    }

    override fun getNewListSize(): Int {
        return newItems.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}