package com.akkobana.rickandmortyapp.presentation.characterinfoscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.akkobana.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCharacterDetailsBinding
    private val vm: CharacterDetailsViewModel by viewModels()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getCharacterInfo()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        observeValues()
    }

    private fun setupListeners() {
        binding.tbProfile.setNavigationOnClickListener {
            vm.setNavigateBackFlag()
        }
    }

    private fun observeValues() {
        vm.characterDetailsLive.observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(root)
                    .load(it.image)
                    .centerCrop()
                    .into(ivCharacterAvatar)
                tvName.text = it.name
                tvStatusContent.text = it.status
                tvSpeciesContent.text = it.species
                tvGenderContent.text = it.gender
                tvCreatedContent.text = it.created
            }
        }
        vm.navigateBackLive.observe(viewLifecycleOwner) {
            findNavController().navigateUp()
        }
    }

    private fun getCharacterInfo() {
        vm.fetchCharacterData(args.id)
    }


}