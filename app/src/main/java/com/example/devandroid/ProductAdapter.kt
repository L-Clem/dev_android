package com.example.devandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter(val products: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layoutContent = view.findViewById<LinearLayout>(R.id.layoutContent)
        val textProductDescription = view.findViewById<TextView>(R.id.textViewProductDescription)
        val textProductName = view.findViewById<TextView>(R.id.textViewProductName)
        val imageViewProduct = view.findViewById<ImageView>(R.id.imageViewProduct)
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ProductAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.cell_product, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        val product = products.get(position)

        holder.textProductName = product.name
        holder.textProductDescription = product.description

        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener
    }

}