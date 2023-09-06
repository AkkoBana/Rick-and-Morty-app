package com.akkobana.rickandmortyapp.presentation.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.databinding.FragmentProfileBinding
import com.akkobana.rickandmortyapp.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val vm: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navigateBack()
        exitFromProfile()
        observeAuthState()
    }

    private fun navigateBack() = with(binding) {
        tbProfile.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun observeAuthState() {
        vm.authStateLive.observe(viewLifecycleOwner) {
            if (!it) {
                requireActivity().finish()
                requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
            }
        }
    }

    private fun exitFromProfile() = with(binding) {
        bExit.setOnClickListener {
            vm.setAuthStateFalse()
        }
    }
}