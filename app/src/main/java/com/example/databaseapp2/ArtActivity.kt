package com.example.databaseapp2

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.databaseapp2.databinding.ActivityArtBinding
import com.google.android.material.snackbar.Snackbar

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
        // toast message
        Toast.makeText(this, "Select Image", Toast.LENGTH_LONG).show()

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            // ask for permission
            if(ActivityCompat.shouldShowRequestPermissionRationale(this , android.Manifest.permission.READ_EXTERNAL_STORAGE))
            Snackbar.make(view, "Permission needed for gallery", Snackbar.LENGTH_INDEFINITE).setAction("Give Permission") {
                // ask for permission
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), 1)
            }.show()
            else {
                // permission granted
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, 2)
            }
        } else {
            // permission granted
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 2)
        }
    }

}