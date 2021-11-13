package com.jeffryhermanto.selfpromoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        val message = intent.getSerializableExtra("Message") as Message
        val messagePreviewText = """
            Hi ${message.contactName},
            
            My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
            
            I have a portfolio of apps to demonstrate my technical skills that I can show on request.
            
            I am able to start a new position ${message.getAvailability()}.
            
            Please get in touch if you have any suitable roles for me.
            
            Thanks and best regards.
        """.trimIndent()
        text_view_messsage.text = messagePreviewText
    }
}