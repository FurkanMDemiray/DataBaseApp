package com.example.databaseapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.databaseapp2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = DataBase(this)
        db.createTable("Users")
        db.insertData("Users", "Ali", 25)
        db.getData("Users")


    }
}