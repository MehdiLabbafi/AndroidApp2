package com.app.mehdi.androidapp2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var itemList: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        itemList = mutableListOf("Iced Capp", "Farmer's Wrap", "Specialty Donuts")

        adapter = MyAdapter(itemList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val addButton: Button = findViewById(R.id.add_button)
        val editText: EditText = findViewById(R.id.edit_text)

        addButton.setOnClickListener {
            val newItem = editText.text.toString()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem)
                adapter.notifyItemInserted(itemList.size - 1)
                editText.text.clear()  // Clear the input field after adding
            }
        }
    }
}
