package com.example.devandroid

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        showBack()

        val category = intent.getSerializableExtra("category") as? Category
        setHeaderTitle("${category?.title}")

        val products = arrayListOf<Product>()

        val recyclerViewProducts = findViewById<RecyclerView>(R.id.recyclerViewProducts)
        recyclerViewProducts.layoutManager = LinearLayoutManager(this)

        val productsAdapter = ProductAdapter(products)
        recyclerViewProducts.adapter = productsAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL = category?.products_url
        val request = mRequestURL?.let {
            Request.Builder()
                .url(it)
                .get()
                .cacheControl(CacheControl.FORCE_NETWORK)
                .build()
        }

        request?.let {
            okHttpClient.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("Epsi", "############## " + e.message.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    val data = response.body?.string()
                    Log.e("Epsi", "################# response.code:" + response.code)
                    if (data != null && response.code == 200) {
                        Log.e("Epsi", data)
                        val jsProducts = JSONObject(data)
                        val jsArrayProducts= jsProducts.getJSONArray("items")
                        for (i in 0 until jsArrayProducts.length()) {
                            val js = jsArrayProducts.getJSONObject(i)
                            val product = Product(
                                js.optString("name", "Not found"),
                                js.optString("description", "Not found"),
                                js.optString("picture_url", "Not found")
                            )
                            products.add(product)
                            runOnUiThread(Runnable {
                                productsAdapter.notifyDataSetChanged()
                            })
                        }
                    }
                }
            })
        }
    }
}