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


        try {
            val myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null)

            myDatabase.execSQL("create TABLE IF NOT EXISTS newUsers (id INTEGER PRİMARY KEY,name VARCHAR, age INT(3))")

            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Ahmet', 25)")

            //myDatabase.execSQL("insert into newUsers (name,age) values('Furkan',23)")

            val cursor = myDatabase.rawQuery("Select id,name,age from newUsers", null)

            val idIx = cursor.getColumnIndex("id")
            val nameIndex = cursor.getColumnIndex("name")
            val ageIndex = cursor.getColumnIndex("age")
            while (cursor.moveToNext()) {
                println("Name: " + cursor.getString(nameIndex))
                println("Age: " + cursor.getInt(ageIndex))
                println("Id: " + cursor.getInt(idIx))
            }
            cursor.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}