package com.akkobana.rickandmortyapp.presentation.adapters.character

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.databinding.ItemCharacterCardBinding
import com.bumptech.glide.Glide

class CharacterViewHolder(
    private val binding: ItemCharacterCardBinding,
    private val setOnClickItem: (id: Int) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CharacterCard) = with(binding) {

        itemView.setOnClickListener {
            setOnClickItem.invoke(item.id)
        }

        if (item.avatar.isNotEmpty()) {
            Glide.with(root)
                .load(item.avatar)
                .override(220, 220)
                .centerCrop()
                .into(ivCharacterAvatar)
            ivCharacterAvatar.isVisible = true
        } else {
            ivCharacterAvatar.isVisible = false
        }

        if (item.name.isNotEmpty()) {
            tvCharacterName.text = item.name
            tvCharacterName.isVisible = true
        } else {
            tvCharacterName.isVisible = false
        }
    }

}