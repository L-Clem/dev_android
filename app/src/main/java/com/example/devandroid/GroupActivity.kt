package com.example.devandroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class GroupActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group)

        setHeaderTitle(getString(R.string.txt_info))
        showBack()


        val buttonEtudiant1 = findViewById<Button>(R.id.etudiant1)
        buttonEtudiant1.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            newIntent.putExtra("student", "etudiant1")
            startActivity(newIntent)
        })

        val buttonEtudiant2 = findViewById<Button>(R.id.etudiant2)
        buttonEtudiant2.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            newIntent.putExtra("student", "etudiant2")
            startActivity(newIntent)
        })

        val buttonEtudiant3 = findViewById<Button>(R.id.etudiant3)
        buttonEtudiant3.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, StudentActivity::class.java)
            newIntent.putExtra("student", "etudiant3")
            startActivity(newIntent)
        })

    }

}