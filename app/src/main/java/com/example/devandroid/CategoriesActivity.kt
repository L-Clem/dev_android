package com.example.devandroid

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CategoriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)
        showBack()
        setHeaderTitle("Rayons")

        val categories = arrayListOf<Category>()

        val recyclerViewCategories = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerViewCategories.layoutManager = LinearLayoutManager(this)

        val categorieAdapter = CategoriesAdapter(categories)
        recyclerViewCategories.adapter = categorieAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = "https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("Epsi", "############## " + e.message.toString())
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()
                Log.e("Epsi", "################# response.code:" + response.code)
                if (data != null && response.code == 200) {
                    Log.e("Epsi", data)
                    val jsCategories = JSONObject(data)
                    val jsArrayCategories = jsCategories.getJSONArray("items")
                    for (i in 0 until jsArrayCategories.length()) {
                        val js = jsArrayCategories.getJSONObject(i)
                        val categorie = Category(
                            js.optInt("category_id", 0),
                            js.optString("title", "Not found"),
                            js.optString("products_url", "Not found")
                        )
                        categories.add(categorie)
                        runOnUiThread(Runnable {
                            categorieAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }
        })
    }
}