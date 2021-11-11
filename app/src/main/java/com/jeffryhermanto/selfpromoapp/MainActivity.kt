package com.jeffryhermanto.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear_layout_main_activity_container.setOnClickListener {
            clearEditTextsFocus()
        }

        button_preview.setOnClickListener {
            onPreviewClicked()
        }
    }

    private fun clearEditTextsFocus() {
        edit_text_contact_name.clearFocus()
        edit_text_contact_number.clearFocus()
        edit_text_my_display_name.clearFocus()
        edit_text_start_date.clearFocus()
    }

    private fun onPreviewClicked() {
        val contactName = edit_text_contact_name.text.toString()
        val contactNumber = edit_text_contact_number.text.toString()
        val myDisplayName = edit_text_my_display_name.text.toString()
        val includeJunior = check_box_junior.isChecked
        val jobTitle = spinner_job_title.selectedItem?.toString()
        val immediateStart = check_box_immediate_start.isChecked
        val startDate = edit_text_start_date.text.toString()

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        startActivity(previewActivityIntent)
    }
}