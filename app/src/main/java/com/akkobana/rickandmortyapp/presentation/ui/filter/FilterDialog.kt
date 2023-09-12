package com.akkobana.rickandmortyapp.presentation.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.akkobana.rickandmortyapp.data.model.FilterEntity
import com.akkobana.rickandmortyapp.databinding.FragmentFilterBinding
import com.akkobana.rickandmortyapp.presentation.adapters.filter.FilterAdapter

class FilterDialog(
    private val entity: FilterEntity,
    private val callBack: (MutableMap<String, String>) -> Unit
) : DialogFragment() {
    private val vm: FilterViewModel by viewModels()
    private lateinit var binding: FragmentFilterBinding
    private val adapter by lazy {
        FilterAdapter(entity) {
            vm.checkCallBack(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRv()
        observeValues()
    }

    private fun initRv() {
        binding.rvFilters.adapter = adapter
    }


    private fun observeValues() {
        vm.dismissDialogFlagLive.observe(viewLifecycleOwner) {
            dismiss()
        }
        vm.filterEntityLive.observe(viewLifecycleOwner) {
            callBack.invoke(vm.filterEntity)
        }
    }
}