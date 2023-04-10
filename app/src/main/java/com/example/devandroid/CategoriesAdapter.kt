package com.example.devandroid

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(val categories: ArrayList<Categories>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layoutContent = view.findViewById<LinearLayout>(R.id.layoutContent)
        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
    }
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categorie = categories.get(position)
        holder.textViewTitle.id = categorie.category_id
        holder.textViewTitle.text = categorie.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutContent.context, ProductsActivity::class.java)
            newIntent.putExtra("category", categorie)
            holder.layoutContent.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}