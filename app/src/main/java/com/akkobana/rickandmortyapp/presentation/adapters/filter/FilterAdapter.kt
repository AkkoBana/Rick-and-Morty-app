package com.akkobana.rickandmortyapp.presentation.adapters.filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.akkobana.rickandmortyapp.data.model.FilterEntity
import com.akkobana.rickandmortyapp.databinding.ItemCategoryFilterBinding
import com.akkobana.rickandmortyapp.databinding.ItemFilterButtonsBinding
import com.akkobana.rickandmortyapp.presentation.adapters.BaseViewHolder

class FilterAdapter(
    private val filterEntity: FilterEntity,
    private val callBack: (CallBack) -> Unit
) : Adapter<BaseViewHolder>() {
    private val main by lazy { filterEntity.main.toMutableList() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ViewType.STATUS_FILTER.ordinal -> FilterStatusViewHolder(
                ItemCategoryFilterBinding.inflate(layoutInflater, parent, false)
            ) {
                callBack.invoke(CallBack.StatusValue(it))
            }
            ViewType.GENDER_FILTER.ordinal -> FilterGenderViewHolder(
                ItemCategoryFilterBinding.inflate(layoutInflater, parent, false)
            ) {
                callBack.invoke(CallBack.GenderValue(it))
            }
            else -> FilterButtonViewHolder(
                ItemFilterButtonsBinding.inflate(layoutInflater, parent, false)
            ) {
               callBack.invoke(CallBack.ButtonListener(it))
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> ViewType.STATUS_FILTER.ordinal
            1 -> ViewType.GENDER_FILTER.ordinal
            else -> ViewType.BUTTONS.ordinal
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is FilterGenderViewHolder -> holder.bind(main[position], filterEntity.gender)
            is FilterStatusViewHolder -> holder.bind(main[position], filterEntity.status)
            is FilterButtonViewHolder -> holder.bind()
        }
    }

    /*fun submitList(newMain: List<String>) {
        val diffCallback = ItemDiffCallback(main, newMain)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        main.clear()
        main.addAll(newMain)
        diffResult.dispatchUpdatesTo(this)
    }*/

    override fun getItemCount(): Int = main.size + 1


    enum class ViewType {
        STATUS_FILTER,
        GENDER_FILTER,
        BUTTONS
    }

    sealed class CallBack {
        class StatusValue(val statusFilterValue: String) : CallBack()
        class GenderValue(val genderFilterValue: String) : CallBack()
        class ButtonListener(val isSaveOrCancel: Boolean) : CallBack()
    }
}
