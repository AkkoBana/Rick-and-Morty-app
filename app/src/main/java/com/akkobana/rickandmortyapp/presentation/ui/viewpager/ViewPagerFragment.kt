package com.akkobana.rickandmortyapp.presentation.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akkobana.rickandmortyapp.R
import com.akkobana.rickandmortyapp.databinding.FragmentViewPagerBinding
import com.akkobana.rickandmortyapp.presentation.adapters.viewpager.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var pagerAdapter: PagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        pagerAdapter = PagerAdapter(this@ViewPagerFragment)
        viewPager.adapter = pagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.setIcon( R.drawable.ic_thumb_up)
                else -> tab.setIcon( R.drawable.ic_thumb_down)
            }
        }.attach()
    }

}