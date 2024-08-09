package com.example.restaurantenovo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantenovo.databinding.FoodItemBinding
import com.example.restaurantenovo.model.Food

class FoodAdapter(private val context: Context, private val foodList: MutableList<Food>): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    inner class FoodViewHolder(binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgFood = binding.imgFood
        val textFoodName = binding.textFoodName
        val textFoodDescricao = binding.textFoodDescricao
        val textFoodPrice = binding.textFoodPrice
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val listItem: FoodItemBinding = FoodItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return FoodViewHolder(listItem)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.imgFood.setBackgroundResource(foodList[position].getImagem())
        holder.textFoodName.text = foodList[position].getNome()
        holder.textFoodDescricao.text = foodList[position].getDescricao()
        holder.textFoodPrice.text = foodList[position].getPreco()
    }
}