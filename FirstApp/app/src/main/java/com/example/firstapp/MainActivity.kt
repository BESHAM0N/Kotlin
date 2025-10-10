package com.example.firstapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view);
        val userData: EditText = findViewById(R.id.user_data);
        val button: Button = findViewById(R.id.button);

        val todos: MutableList<String> = mutableListOf();
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos);
        listView.adapter = adapter;

        listView.setOnItemClickListener { adapterView, view, position, j ->
            val text = listView.getItemAtPosition(position).toString();
            adapter.remove(text);
            Toast.makeText(this, "Мы удалили: $text", Toast.LENGTH_LONG).show();
        }

        button.setOnClickListener {
            val text = userData.text.toString().trim();
            if(text != "")
                adapter.insert(text, 0);
        }
    }
}

