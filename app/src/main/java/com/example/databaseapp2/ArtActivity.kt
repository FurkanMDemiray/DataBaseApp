package com.example.databaseapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.databaseapp2.databinding.ActivityArtBinding

class ArtActivity : AppCompatActivity() {
    // add view binding here
    private lateinit var binding: ActivityArtBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set content view here
        binding = ActivityArtBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    fun saveButton(view: View) {

    }

    fun selectImage(view: View) {

    }

}