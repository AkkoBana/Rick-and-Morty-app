package com.akkobana.rickandmortyapp.presentation.profilescreen

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.R
import com.akkobana.rickandmortyapp.databinding.FragmentProfileBinding
import com.akkobana.rickandmortyapp.presentation.MainActivity
import com.google.android.material.appbar.MaterialToolbar
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
        binding.tbProfile.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        exiteFromProfile()
    }

    private fun exiteFromProfile() = with(binding) {
        bExit.setOnClickListener {
            vm.authStateFlag.observe(viewLifecycleOwner){
                if(!it){
                    requireActivity().finish()
                    requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
                }
            }
            vm.setAuthStateFalse()
        }
    }
}