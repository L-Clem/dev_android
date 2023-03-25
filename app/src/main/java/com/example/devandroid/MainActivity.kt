package com.example.devandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.content.Intent

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.txt_epsi))

        val buttonInfo = findViewById<Button>(R.id.buttonInfo)
        buttonInfo.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, GroupActivity::class.java)
            newIntent.putExtra("title", getString(R.string.txt_info))

            startActivity(newIntent)
        })

        val buttonProduits = findViewById<Button>(R.id.buttonProduits)
        buttonProduits.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, CategoriesActivity::class.java)
            newIntent.putExtra("title", getString(R.string.txt_produits))
            startActivity(newIntent)
        })
    }
}
