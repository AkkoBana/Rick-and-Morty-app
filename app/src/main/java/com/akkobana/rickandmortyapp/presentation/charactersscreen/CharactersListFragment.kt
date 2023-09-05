package com.akkobana.rickandmortyapp.presentation.charactersscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
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
        getResponseList()
    }

    private fun getResponseList() {
        vm.fetchNameAndImage()
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
    ): View {
        binding = FragmentCharacterListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRv()
        checkAuthState()
        observeLiveValue()
        setupListener()
    }

    private fun setupListener() = with(binding) {
        ibCloseSearchCharacters.setOnClickListener {
            vm.fetchNameAndImage("")
        }
        bToProfileFragment.setOnClickListener {
            findNavController()
                .navigate(
                    CharactersListFragmentDirections
                        .actionCharactersListFragmentToProfileFragment()
                )
        }
        etSearchCharacters.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                vm.fetchNameAndImage(etSearchCharacters.text.toString().lowercase())
            }
            true
        }
        swipeRefresh.setOnRefreshListener {
            progressBar.isVisible = true
            vm.fetchNameAndImage()
        }

    }

    private fun observeLiveValue() {
        vm.characterListLive.observe(viewLifecycleOwner) {
            adapter.updateItems(it)
        }
        vm.authStateLive.observe(viewLifecycleOwner) {
            if (!it) {
                findNavController().navigate(
                    CharactersListFragmentDirections
                        .actionCharactersListFragmentToAuthNavGraph()
                )
            }
        }
        vm.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {
                swipeRefresh.isRefreshing = isLoading
                progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }
    }

    private fun initRv() {
        binding.rvCharacterList.adapter = adapter
    }

    private fun checkAuthState() {
        vm.checkAuthState()
    }
}