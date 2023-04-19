package com.example.databaseapp2

import android.content.Context.MODE_PRIVATE
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase

class DataBase(MainActivity: MainActivity) {

    val database = MainActivity.openOrCreateDatabase("mydatabase", MODE_PRIVATE, null)

    fun createTable(tableName: String) {
        // create database
        database.execSQL("CREATE TABLE IF NOT EXISTS tableName (id INTEGER PRIMARY KEY, name VARCHAR, age INT(3))")
    }

    fun insertData(tableName: String, name: String, age: Int) {
        // insert data
        database.execSQL("INSERT INTO tableName (name, age) VALUES ('$name', '$age')")

    }

    fun getData(tableName: String) {
        // get data
        val cursor = database.rawQuery("SELECT * FROM tableName", null)
        val idIndex = cursor.getColumnIndex("id")
        val nameIndex = cursor.getColumnIndex("name")
        val ageIndex = cursor.getColumnIndex("age")

        while (cursor.moveToNext()) {
            println("ID: ${cursor.getInt(idIndex)}")
            println("Name: ${cursor.getString(nameIndex)}")
            println("Age: ${cursor.getInt(ageIndex)}")
        }
        cursor.close()
    }
}