package edu.temple.startingservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextTime)
        val buttonStartService = findViewById<Button>(R.id.startButton)

        buttonStartService.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            intent.putExtra("countdownValue", editTextNumber.text.toString().toInt())
            startService(intent)
        }
    }
}