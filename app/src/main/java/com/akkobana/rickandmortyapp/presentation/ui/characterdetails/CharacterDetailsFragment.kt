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
import com.akkobana.rickandmortyapp.R
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
    ): View {
        binding = FragmentCharacterDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupListeners()
        observeValues()
        vm.fetchLikedCharacterFromTable(args.id)
        vm.fetchDislikedCharacterFromTable(args.id)
    }

    private fun setupListeners() = with(binding) {
        tbProfile.setNavigationOnClickListener {
            vm.setNavigateBackFlag()
        }
        ibFavourite.setOnClickListener {
            vm.changeIsLikedValue()
        }
        ibLeastLiked.setOnClickListener {
            vm.changeIsDislikedValue()
        }
    }

    private fun observeValues() {
        vm.characterDetailsLive.observe(viewLifecycleOwner) {
            with(binding) {
                Glide.with(root)
                    .load(it.image)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(
                            e: GlideException?,
                            model: Any?,
                            target: Target<Drawable>,
                            isFirstResource: Boolean
                        ): Boolean {
                            vm.setIsLoadingFalse()
                            return false
                        }
                        override fun onResourceReady(
                            resource: Drawable,
                            model: Any,
                            target: Target<Drawable>?,
                            dataSource: DataSource,
                            isFirstResource: Boolean
                        ): Boolean {
                            vm.setIsLoadingFalse()
                            return false
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
        vm.isLoadingLive.observe(viewLifecycleOwner) { isLoading ->
            binding.flProgressBar.isVisible = isLoading
        }
        vm.isLikedLive.observe(viewLifecycleOwner) { isFavourite ->
            if (isFavourite) {
                binding.ibFavourite.setImageResource(R.drawable.ic_thumb_up)
                vm.insertLikedCharacterInTable(args.id)
            } else {
                binding.ibFavourite.setImageResource(R.drawable.ic_thumb_up_off)
                vm.deleteLikedCharacterFromTable(args.id)
            }
        }
        vm.isDislikedLive.observe(viewLifecycleOwner) { isLeastLiked ->
            if (isLeastLiked) {
                binding.ibLeastLiked.setImageResource(R.drawable.ic_thumb_down)
                vm.insertDislikedCharacterInTable(args.id)
            } else {
                binding.ibLeastLiked.setImageResource(R.drawable.ic_thumb_down_off)
                vm.deleteDislikedCharacterFromTable(args.id)
            }
        }
    }

    private fun getCharacterInfo() {
        vm.fetchCharacterData(args.id)
    }


}