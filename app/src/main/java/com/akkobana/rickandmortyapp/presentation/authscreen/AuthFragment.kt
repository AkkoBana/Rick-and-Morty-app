package com.akkobana.rickandmortyapp.presentation.authscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.akkobana.rickandmortyapp.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding
    private val vm: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        openSignUpFragment()
        openSignInFragment()
    }

    fun openSignUpFragment() = with(binding) {
        bSignUp.setOnClickListener {
            vm.navigateToSignUpLive.observe(viewLifecycleOwner) {
                findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToSignUpFragment())
            }
            vm.navigateToSignUpFragment()
        }
    }

    fun openSignInFragment() = with(binding) {
        bSignIn.setOnClickListener {
            vm.navigateToSignInLive.observe(viewLifecycleOwner) {
                findNavController().navigate(AuthFragmentDirections.actionAuthFragmentToSignInFragment())
            }
            vm.navigateToSignInFragment()
        }
    }


}
