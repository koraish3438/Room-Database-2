package com.example.roomdatabase2.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase2.R
import com.example.roomdatabase2.database.Profile
import com.example.roomdatabase2.databinding.ActivityAddProfileBinding
import com.example.roomdatabase2.viewModel.ProfileViewModel

class AddProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProfileBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProfileViewModel(application)

        binding.btnSaveProfile.setOnClickListener { 
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val dob = binding.editTextDob.text.toString()
            val number = binding.editTextNumber.text.toString()
            val district = binding.editTextDistrict.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && dob.isNotEmpty() && number.isNotEmpty() && district.isNotEmpty()) {
                val profile = Profile(
                    name = name,
                    email = email,
                    dob = dob,
                    number = number,
                    district = district
                )
                viewModel.insertProfile(profile)
                finish()
            }
            else {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }


    }
}