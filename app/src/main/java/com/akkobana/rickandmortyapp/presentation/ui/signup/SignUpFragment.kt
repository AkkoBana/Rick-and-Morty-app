package com.akkobana.rickandmortyapp.presentation.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akkobana.rickandmortyapp.databinding.FragmentSignUpBinding
import com.akkobana.rickandmortyapp.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpFragment : Fragment() {


    private lateinit var binding: FragmentSignUpBinding
    private val vm: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signUp()
    }

    private fun signUp() = with(binding) {
        vm.isSavedLive.observe(viewLifecycleOwner) {
            requireActivity().finish()
            requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        bSignUpAuth.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()
            vm.saveUserData(login, password)
        }
    }

}