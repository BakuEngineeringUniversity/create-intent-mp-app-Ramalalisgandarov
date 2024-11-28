package com.example.myapplicationhw

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailTextView: TextView = findViewById(R.id.textView2)
        emailTextView.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:raliisgenderov@std.beu.edu.az")
            }
            startActivity(Intent.createChooser(emailIntent, "Gmail ilə göndərin"))
        }

        val locationTextView: TextView = findViewById(R.id.textView4)
        locationTextView.setOnClickListener {
            val geoUri = "geo:0,0?q=Baku, Azerbaijan"
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri)).apply {
                setPackage("com.google.android.apps.maps")
            }
            if (mapIntent.resolveActivity(packageManager) != null) {
                startActivity(mapIntent)
            } else {
                val fallbackIntent = Intent(Intent.ACTION_VIEW, Uri.parse(geoUri))
                startActivity(fallbackIntent)
            }
        }


        val phoneTextView: TextView = findViewById(R.id.textView3)
        phoneTextView.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:+994558920042")
            }
            startActivity(phoneIntent)
        }
    }
}