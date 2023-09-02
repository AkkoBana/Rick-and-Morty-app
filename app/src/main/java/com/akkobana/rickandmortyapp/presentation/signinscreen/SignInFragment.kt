package com.akkobana.rickandmortyapp.presentation.signinscreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akkobana.rickandmortyapp.R
import com.akkobana.rickandmortyapp.databinding.FragmentSignInBinding
import com.akkobana.rickandmortyapp.databinding.FragmentSignUpBinding
import com.akkobana.rickandmortyapp.presentation.MainActivity
import com.akkobana.rickandmortyapp.presentation.MainApplication

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val vm: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signIn()
    }

    private fun signIn() = with(binding) {
        bSignInAuth.setOnClickListener {
            vm.validationFlag.observe(viewLifecycleOwner) {
                requireActivity().finish()
                requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
            }

            val login = etLogin.text.toString()
            val password = etPassword.text.toString()
            vm.checkUserEntry(login, password)
        }
    }
}