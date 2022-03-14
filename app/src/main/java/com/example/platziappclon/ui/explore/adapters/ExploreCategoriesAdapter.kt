package com.example.platziappclon.ui.explore.adapters

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.platziappclon.data.model.CategoriesModel
import com.example.platziappclon.databinding.CardCategoriesItemBinding

class ExploreCategoriesAdapter(
    private val categories: List<CategoriesModel>
) : RecyclerView.Adapter<ExplorerCategoriesViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExplorerCategoriesViewHolder {
        val viewBinding = CardCategoriesItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExplorerCategoriesViewHolder(viewBinding.root, viewBinding)
    }

    override fun getItemCount(): Int = categories.size

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ExplorerCategoriesViewHolder, position: Int) =
        holder.bindData(categories[position] as CategoriesModel)

}