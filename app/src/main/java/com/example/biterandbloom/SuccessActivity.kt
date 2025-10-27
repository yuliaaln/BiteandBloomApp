package com.example.biterandbloom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SuccessActivity : AppCompatActivity() {

    private var currentName: String = "Guest"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        supportActionBar?.hide()

        currentName = intent.getStringExtra("EXTRA_NAME") ?: "Guest"

        val haloTextView = findViewById<TextView>(R.id.tv_halo_name_success)
        haloTextView.text = "Pesanan Dari Kak $currentName Di Proses"

        val kirimButton = findViewById<Button>(R.id.btn_kirim_success)
        kirimButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("EXTRA_NAME", currentName)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivity(intent)
            finishAffinity()
        }
    }
}