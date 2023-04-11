package com.example.devandroid

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(val categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layoutContent: LinearLayout = view.findViewById<LinearLayout>(R.id.layoutContentCategories)
        val textViewTitle: TextView = view.findViewById<TextView>(R.id.textViewTitle)
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
        val category = categories[position]
        holder.textViewTitle.id = category.category_id
        holder.textViewTitle.text = category.title


        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Log.e("Epsi", "################# clickkk")
            val newIntent: Intent =  Intent(holder.layoutContent.context, ProductsActivity::class.java)
            newIntent.putExtra("category", category.title)
            holder.layoutContent.context.startActivity(newIntent)
        })
        Log.e("Epsi", "################# click " + holder.layoutContent.hasOnClickListeners())
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}

