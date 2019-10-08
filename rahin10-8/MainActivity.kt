package com.example.budgetminimalism

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about_view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        ViewButton.setOnClickListener {
            d("rain","button was pressed")
            startActivity(Intent(this,AboutView::class.java))
        }
        RecentActivityButton.setOnClickListener {
            d("rain","button 2 was pressed")
            startActivity(Intent(this,AboutRecentActivity::class.java))
        }
    }
}
