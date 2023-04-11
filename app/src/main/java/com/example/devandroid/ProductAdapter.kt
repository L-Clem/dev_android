package com.example.devandroid

import android.content.Intent
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
        val layoutContent: LinearLayout = view.findViewById<LinearLayout>(R.id.layoutContentProduct)
        var textProductDescription: TextView = view.findViewById<TextView>(R.id.textViewProductDescription)
        var textProductName: TextView = view.findViewById<TextView>(R.id.textViewProductName)
        val imageViewProduct: ImageView = view.findViewById<ImageView>(R.id.imageViewProduct)
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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]

        holder.textProductName.text = product.name
        holder.textProductDescription.text = product.description

        Picasso.get().load(product.picture_url).into(holder.imageViewProduct)
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutContent.context, ProductDetailsActivity::class.java)
            newIntent.putExtra("product", product.name)
            holder.layoutContent.context.startActivity(newIntent)
        })
    }
}