package com.example.menu_makanan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.menu_makanan.databinding.ItemFoodBinding

class FoodAdapter(private val listFood: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item = listFood[position]
        holder.binding.itemMakanan = item
        holder.binding.imgMenu.setImageResource(item.gambar)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int {
        return listFood.size
    }
}