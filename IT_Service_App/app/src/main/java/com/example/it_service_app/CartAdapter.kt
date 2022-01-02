package com.example.it_service_app

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.it_service_app.databinding.RecyclerviewBinding

class CartAdapter: RecyclerView.Adapter<CartAdapter.CartHolder>() {
    val cart_list = ArrayList<Cart_item>()

    class CartHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = RecyclerviewBinding.bind(item)
        fun bind(item: Cart_item) = with(binding){
            imageView2.setImageResource(item.imageId)
            nameView.text =  item.name
            descriptionView.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return CartHolder(view)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        holder.bind(cart_list[position])
    }

    override fun getItemCount(): Int {
        return cart_list.size
    }

    fun addCart(cartItem: Cart_item){
        cart_list.add(cartItem)
        notifyDataSetChanged()
    }

}