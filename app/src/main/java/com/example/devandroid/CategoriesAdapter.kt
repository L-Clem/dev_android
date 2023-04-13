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


class CategoriesAdapter(val categories: ArrayList<Category>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        Log.e("DevAI","#######################  "+ category.title)
        holder.textViewTitle.text = category.title
        holder.itemView.setOnClickListener {
            val intent = createIntentForItem(category, holder.itemView.context)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    private fun createIntentForItem(item: Category, context: Context): Intent {
        val intent = Intent(context, ProductsActivity::class.java)
        intent.putExtra("category", item.title)
        return intent
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val layoutContent: LinearLayout = itemView.findViewById<LinearLayout>(R.id.layoutContentCategories)
        val textViewTitle: TextView = itemView.findViewById<TextView>(R.id.textViewTitle)
    }
}

