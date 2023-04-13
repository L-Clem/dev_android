package com.example.devandroid

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.NonDisposableHandle.parent


class CategoriesAdapter (private val categories: ArrayList<Category>):RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    class ViewHolder(view:View) :RecyclerView.ViewHolder(view){
        val textViewTitle: TextView = view.findViewById(R.id.textViewTitle)
        val layoutContent: LinearLayout = view.findViewById(R.id.layoutContentCategoriesItem)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.textViewTitle.text=category.title
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutContent.context, ProductsActivity::class.java)
            newIntent.putExtra("category", category)
            holder.layoutContent.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}

