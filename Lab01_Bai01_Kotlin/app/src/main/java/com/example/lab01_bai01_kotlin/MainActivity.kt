package com.example.lab01_bai01_kotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.LinearLayout
import android.widget.TextView

private lateinit var llNameContainer: LinearLayout
private lateinit var llAddressContainer: LinearLayout
private lateinit var llParentContainer: LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        createNameContainer(this)
        createAddressContainer(this)
        createParentContainer(this)
        setContentView(llParentContainer)
    }
}

private fun createNameContainer(context: MainActivity) {
    llNameContainer = LinearLayout(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        orientation = LinearLayout.HORIZONTAL
    }
    val tvName = TextView(context).apply {
        text = "Name: "
    }
    llNameContainer.addView(tvName)

    val tvNameValue = TextView(context).apply {
        text = "John Doe"
    }
    llNameContainer.addView(tvNameValue)
}

private fun createAddressContainer(context: MainActivity) {
    llAddressContainer = LinearLayout(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        orientation = LinearLayout.HORIZONTAL
    }
    val tvAddress = TextView(context).apply {
        text = "Address:"
    }
    llAddressContainer.addView(tvAddress)

    val tvAddressValue = TextView(context).apply {
        text = "911 Hollywood Blvd"
    }
    llAddressContainer.addView(tvAddressValue)
}

private fun createParentContainer(context: MainActivity) {
    llParentContainer = LinearLayout(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        orientation = LinearLayout.VERTICAL
    }
    llParentContainer.addView(llNameContainer)
    llParentContainer.addView(llAddressContainer)
}