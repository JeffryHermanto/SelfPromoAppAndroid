package com.jeffryhermanto.selfpromoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear_layout_main_activity_container.setOnClickListener {
            clearEditTextsFocus()
        }

        val jobTitleValues: Array<String> =
            arrayOf("Android Developer", "iOS Developer", "Flutter Developer")
        val jobTitleAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, jobTitleValues)
        spinner_job_title.adapter = jobTitleAdapter

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
        previewActivityIntent.putExtra("Contact Name", contactName)
        previewActivityIntent.putExtra("Contact Number", contactNumber)
        previewActivityIntent.putExtra("My Display Name", myDisplayName)
        previewActivityIntent.putExtra("Include Junior", includeJunior)
        previewActivityIntent.putExtra("Job Title", jobTitle)
        previewActivityIntent.putExtra("Immediate Start", immediateStart)
        previewActivityIntent.putExtra("Start Date", startDate)
        startActivity(previewActivityIntent)
    }
}