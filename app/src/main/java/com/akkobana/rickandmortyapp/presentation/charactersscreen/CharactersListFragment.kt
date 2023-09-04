package com.akkobana.rickandmortyapp.presentation.charactersscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.databinding.FragmentCharacterListBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CharactersListFragment : androidx.fragment.app.Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val vm: CharactersListViewModel by viewModels()
    private lateinit var adapter: CharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapter = CharacterAdapter(mutableListOf()) {
            findNavController()
                .navigate(
                    CharactersListFragmentDirections
                        .actionCharactersListFragmentToCharacterInfoFragment(it)
                )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        intitRv()
        checkAuthState()
        navigateToProfileFragment()
        updateRv()
        searchCharacters()
    }

    private fun searchCharacters() = with(binding) {
        ibSearchCharacters.setOnClickListener {
            vm.searchCharacterList.observe(viewLifecycleOwner) {
                adapter.updateItems(it)
            }
            vm.filterCharacterList(etSearchCharacters.text.toString())
        }
    }

    private fun intitRv() {
        binding.rvCharacterList.adapter = adapter
    }

    private fun updateRv() {
        vm.characterList.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }

        vm.fetchNameAndImage()
    }

    private fun checkAuthState() {
        vm.authState.observe(viewLifecycleOwner) {
            if (!it) {
                findNavController()
                    .navigate(
                        CharactersListFragmentDirections
                            .actionCharactersListFragmentToAuthNavGraph()
                    )
            }
        }
        vm.checkAuthState()
    }

    private fun navigateToProfileFragment() = with(binding) {
        bToProfileFragment.setOnClickListener {
            vm.navigateToProfileFragmentFlag.observe(viewLifecycleOwner) {
                findNavController()
                    .navigate(
                        CharactersListFragmentDirections
                            .actionCharactersListFragmentToProfileFragment()
                    )
            }
            vm.changeNavigateToProfileFragmentFlag()
        }
    }

}