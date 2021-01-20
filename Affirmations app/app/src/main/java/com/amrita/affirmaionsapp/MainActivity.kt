package com.amrita.affirmaionsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.amrita.affirmaionsapp.adapter.ItemAdapter
import com.amrita.affirmaionsapp.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mydataset = DataSource().loadAffirmations()
        val recyclerview = findViewById<RecyclerView>(R.id.recycler_view)

        recyclerview.adapter = ItemAdapter(this,mydataset)
        recyclerview.setHasFixedSize(true)

    }
}