package com.example.platziappclon.ui.explore.adapters

import android.graphics.Color
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.databinding.CardCategoriesItemBinding

class ExplorerCategoriesViewHolder(
    view: View,
    private val binding: CardCategoriesItemBinding
) : RecyclerView.ViewHolder(view) {

    @RequiresApi(Build.VERSION_CODES.M)
    fun bindData(category: CategoriesModel) {
        binding.apply {
            layoutCategoriesItemBg.setCardBackgroundColor(Color.parseColor(category.color))
            textViewCategoriesItem.text = category.title
        }
    }
}