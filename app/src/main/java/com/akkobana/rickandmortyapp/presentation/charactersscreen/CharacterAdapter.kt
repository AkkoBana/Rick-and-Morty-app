package com.akkobana.rickandmortyapp.presentation.charactersscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.databinding.ItemCharacterCardBinding
import com.akkobana.rickandmortyapp.utils.ItemDiffCallback
import com.bumptech.glide.Glide

class CharacterAdapter(
    private val characters: MutableList<CharacterCard>,
    private val setOnClickItem: (id: Int) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    lateinit var binding: ItemCharacterCardBinding

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

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterAdapter.CharacterViewHolder {
        binding =
            ItemCharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding) {
            setOnClickItem.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int =
        characters.size


    fun updateItems(newCharacters: List<CharacterCard>) {
        val diffCallback = ItemDiffCallback(characters, newCharacters)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        characters.clear()
        characters.addAll(newCharacters)
        diffResult.dispatchUpdatesTo(this)
    }

}