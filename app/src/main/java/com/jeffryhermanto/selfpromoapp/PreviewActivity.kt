package com.jeffryhermanto.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        val message = intent.getSerializableExtra("Message") as Message
    }
}