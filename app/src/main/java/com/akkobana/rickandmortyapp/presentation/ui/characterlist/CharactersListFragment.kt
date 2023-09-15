package com.akkobana.rickandmortyapp.presentation.ui.characterlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.databinding.FragmentCharacterListBinding
import com.akkobana.rickandmortyapp.presentation.adapters.character.CharacterAdapter
import com.akkobana.rickandmortyapp.presentation.ui.filter.FilterDialog
import com.akkobana.rickandmortyapp.utils.ExtensionsKeyboardUtil.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharacterListBinding
    private val vm: CharactersListViewModel by viewModels()
    private val adapter by lazy {
        CharacterAdapter(mutableListOf()) {
            vm.characterAdapterCallBack(it) { id ->
                findNavController()
                    .navigate(
                        CharactersListFragmentDirections.actionCharactersListFragmentToCharacterInfoFragment(
                            id
                        )
                    )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getResponseList()
        hideKeyboard()
    }

    private fun getResponseList() {
        vm.fetchNameAndImage()
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
        observeFlowState()
        setupListener()
    }

    private fun setupListener() = with(binding) {
        ibCloseSearchCharacters.setOnClickListener {
            vm.fetchNameAndImage("")
            hideKeyboard()
            etSearchCharacters.text?.clear()
        }
        bToProfileFragment.setOnClickListener {
            findNavController()
                .navigate(
                    CharactersListFragmentDirections.actionCharactersListFragmentToProfileFragment()
                )
        }
        etSearchCharacters.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                vm.fetchNameAndImage(etSearchCharacters.text.toString().lowercase())
            }
            true
        }
        swipeRefresh.setOnRefreshListener {
            vm.fetchNameAndImage()
            binding.swipeRefresh.isRefreshing = false
        }
        ibMenu.setOnClickListener {
            val filterDialog = FilterDialog(vm.filterEntity) {
                if (it[FAVOURITES_KEY] == "true") {
                    vm.fetchNameAndImage(status = it[STATUS_KEY], gender = it[GENDER_KEY])
                } else {
                    vm.fetchNameAndImage(status = it[STATUS_KEY], gender = it[GENDER_KEY])
                }
            }
            filterDialog.show(parentFragmentManager, "dialog fragment")

        }
        bViewPageFragment.setOnClickListener {
            findNavController().navigate(CharactersListFragmentDirections.actionCharactersListFragmentToViewPagerFragment())
        }
    }

    private fun observeFlowState() {
        vm.characterListState.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        lifecycleScope.launch(Dispatchers.IO) {
            vm.authStateState.collect {
                if (!it) {
                    findNavController().navigate(
                        CharactersListFragmentDirections.actionCharactersListFragmentToAuthNavGraph()
                    )
                }
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            vm.isLoadingState.collect { isLoading ->
                binding.rvCharacterList.isVisible = !isLoading
                binding.progressBar.isVisible = isLoading
            }
        }
    }

    private fun initRv() {
        binding.rvCharacterList.adapter = adapter
    }

    private fun checkAuthState() {
        vm.checkAuthState()
    }

    companion object {
        const val STATUS_KEY = "status"
        const val GENDER_KEY = "gender"
        const val FAVOURITES_KEY = "favourites"
    }
}