package com.akkobana.rickandmortyapp.presentation.ui.signin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akkobana.rickandmortyapp.databinding.FragmentSignInBinding
import com.akkobana.rickandmortyapp.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private val vm: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        signIn()
        observeCheckCredential()
    }

    private fun observeCheckCredential() {
        vm.checkCredentialLive.observe(viewLifecycleOwner) {
            if (it) {
                requireActivity().finish()
                requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
            } else {
                Toast.makeText(requireContext(), vm.toastErrorText, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun signIn() = with(binding) {
        bSignInAuth.setOnClickListener {
            val login = etLogin.text.toString()
            val password = etPassword.text.toString()
            vm.checkUserEntry(login, password)
        }
    }
}