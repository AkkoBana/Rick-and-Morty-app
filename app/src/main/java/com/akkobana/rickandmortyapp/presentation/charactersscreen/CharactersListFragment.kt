package com.akkobana.rickandmortyapp.presentation.charactersscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.databinding.FragmentCharactersListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersListFragment : Fragment() {

    private lateinit var binding: FragmentCharactersListBinding
    private val vm: CharactersListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        checkAuthState()
        navigateToProfileFragment()
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
            vm.navigateToProfileFragment()
        }
    }

}