package com.akkobana.rickandmortyapp.presentation.ui.filter

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.akkobana.rickandmortyapp.data.model.FilterEntity
import com.akkobana.rickandmortyapp.databinding.FragmentFilterBinding
import com.akkobana.rickandmortyapp.presentation.adapters.filter.FilterAdapter

class FilterDialog(private val list: FilterEntity): DialogFragment() {
    private lateinit var binding: FragmentFilterBinding
    private val adapter by lazy { FilterAdapter(list) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvFilters.adapter = adapter
    }

    override fun dismiss() {
        super.dismiss()
    }
}