package com.example.devandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        showBack()
        setHeaderTitle(intent.extras?.getString("name"))

        val editAvatar = findViewById<ImageView>(R.id.imageViewProduct)
        editAvatar.setImageResource(R.drawable.logo_marche)

        val editDescription = findViewById<TextView>(R.id.textViewProductDescription)
        editDescription.setText(intent.extras?.getString("description"))
    }
}
