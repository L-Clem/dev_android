package com.example.devandroid

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        showBack()

        val product = intent.getSerializableExtra("product") as? Product
        setHeaderTitle("${product?.name}")

        val editAvatar = findViewById<ImageView>(R.id.imageViewProduct)
        Picasso.get().load(product?.picture_url).into(editAvatar)


        val editDescription = findViewById<TextView>(R.id.textViewProductDescription)
        editDescription.setText(product?.description)
    }
}
