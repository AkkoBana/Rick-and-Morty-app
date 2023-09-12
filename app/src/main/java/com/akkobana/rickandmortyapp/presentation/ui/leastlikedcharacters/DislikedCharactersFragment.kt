package com.akkobana.rickandmortyapp.presentation.ui.leastlikedcharacters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akkobana.rickandmortyapp.data.model.CharacterCard
import com.akkobana.rickandmortyapp.databinding.FragmentLikedDislikedCharactersBinding
import com.akkobana.rickandmortyapp.presentation.adapters.character.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DislikedCharactersFragment : Fragment() {

    private val vm: DislikedCharactersViewModel by viewModels()
    private lateinit var binding: FragmentLikedDislikedCharactersBinding
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        vm.fetchLeastLikedCharacters()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLikedDislikedCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeValues()
        initRv()
    }
    private fun initRv() {
        binding.rvLikedDisliked.adapter = adapter
    }


    private fun observeValues() {
        vm.dislikedCharactersListLive.observe(viewLifecycleOwner) {
            submitAdapter(it)
        }
    }

    private fun initAdapter() {
        adapter = CharacterAdapter(mutableListOf()) {

        }
    }

    private fun submitAdapter(newCharacterList: List<CharacterCard>) {
        adapter.submitList(newCharacterList)
    }

}