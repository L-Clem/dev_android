package com.example.devandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.ImageView
import android.widget.TextView
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class StudentActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        showBack()

        var Students : JSONObject = JSONObject(loadJSONFromAsset(this))

        val Student = Students.getJSONObject(intent.extras?.getString("student"))

        setHeaderTitle(Student.get("lastName").toString())

        val names = StringBuilder()
        names.append(Student.get("firstName")).append(" ").append(Student.get("lastName"))

        val editAvatar = findViewById<ImageView>(R.id.avatar)
        editAvatar.setImageResource(R.drawable.logo_marche)
        val editNames = findViewById<TextView>(R.id.textViewNames)
        editNames.setText(names.toString())
        val editEmail = findViewById<TextView>(R.id.textViewEmail)
        editEmail.setText(Student.get("email").toString())
        val editGroup = findViewById<TextView>(R.id.textViewGroup)
        editGroup.setText(Student.get("group").toString())

    }
    fun loadJSONFromAsset(context: Context): String? {
        var json: String? = null
        json = try {
            val `is`: InputStream = context.getAssets().open("Students.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}