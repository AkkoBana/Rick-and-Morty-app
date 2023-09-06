package com.akkobana.rickandmortyapp.presentation.ui.characterdetails

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.akkobana.rickandmortyapp.databinding.FragmentCharacterDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
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
                    .listener(object : RequestListener<Drawable>{
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>,
                            isFirstResource: Boolean
                        ): Boolean {
                            return false
                        }

                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            return true
                        }

                    })
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
        vm.isLoading.observe(viewLifecycleOwner) { isLoading ->
            with(binding) {



                flProgressBar.isVisible = isLoading
            }
        }
    }

    private fun getCharacterInfo() {
        vm.fetchCharacterData(args.id)
    }


}