package com.akkobana.rickandmortyapp.presentation.adapters.viewpager

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.akkobana.rickandmortyapp.presentation.ui.favourites.LikedCharactersFragment
import com.akkobana.rickandmortyapp.presentation.ui.leastlikedcharacters.DislikedCharactersFragment

class PagerAdapter(
    fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> LikedCharactersFragment()
            else -> DislikedCharactersFragment()
        }
    }

}