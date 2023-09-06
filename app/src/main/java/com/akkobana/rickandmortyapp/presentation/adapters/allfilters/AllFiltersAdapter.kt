package com.akkobana.rickandmortyapp.presentation.adapters.allfilters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akkobana.rickandmortyapp.databinding.ItemFiltersBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder
import com.akkobana.rickandmortyapp.presentation.adapters.filter.FilterAdapter

class AllFiltersAdapter(private val mainList: List<String>, private val viewType: FilterAdapter.ViewType) :
    RecyclerView.Adapter<BaseViewHolder>() {
    private var oldPosition: Int? = null
    private var newPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.STATUS_TYPE.ordinal -> StatusViewHolder(
                ItemFiltersBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )

            else -> GenderViewHolder(
                ItemFiltersBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            ) {
                if(newPosition != it) newPosition = it
                updateItem(it)
            }
        }
    }

    override fun getItemCount(): Int = mainList.size


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is StatusViewHolder -> holder.bind(mainList[position])
            is GenderViewHolder -> holder.bind(mainList[position], oldPosition)
        }
        oldPosition = newPosition
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewType) {
            FilterAdapter.ViewType.STATUS_FILTER -> ViewType.STATUS_TYPE.ordinal
            else -> ViewType.GENDER_TYPE.ordinal
        }
    }

    private fun updateItem(position: Int) {
        if(oldPosition != null) {
            this.notifyItemChanged(oldPosition!!)
        } else {
            oldPosition = position
        }
    }

    enum class ViewType {
        STATUS_TYPE,
        GENDER_TYPE
    }

    companion object {
        const val STATUS_FILTER = "Status"
        const val GENDER_FILTER = "Gender"
    }
}