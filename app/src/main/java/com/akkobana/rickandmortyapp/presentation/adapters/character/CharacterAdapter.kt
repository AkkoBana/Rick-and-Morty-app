package com.akkobana.rickandmortyapp.presentation.adapters.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.databinding.ItemCharacterCardBinding
import com.akkobana.rickandmortyapp.utils.ItemDiffCallback

class CharacterAdapter(
    private val characters: MutableList<CharacterCard>,
    private val setOnClickItem: (id: Int) -> Unit
) : RecyclerView.Adapter<CharacterViewHolder>() {

    lateinit var binding: ItemCharacterCardBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        binding =
            ItemCharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding) {
            setOnClickItem.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
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