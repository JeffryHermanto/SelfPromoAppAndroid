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
        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_my_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)
        startActivity(previewActivityIntent)
    }
}