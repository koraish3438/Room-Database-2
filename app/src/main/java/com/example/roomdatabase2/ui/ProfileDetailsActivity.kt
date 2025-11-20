package com.example.roomdatabase2.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase2.database.Profile
import com.example.roomdatabase2.databinding.ActivityProfileDetailsBinding
import com.example.roomdatabase2.viewModel.ProfileViewModel

class ProfileDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileDetailsBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var currentProfile: Profile
    private var profileId: Int = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProfileViewModel(application)

        profileId = intent.getIntExtra("profileId", 0)

        viewModel.getAllProfiles().observe(this) { profiles ->
            currentProfile = profiles.find { it.id == profileId } ?: return@observe

            binding.textName.text = currentProfile.name
            binding.textEmail.text = currentProfile.email
            binding.textDob.text = currentProfile.dob
            binding.textNumber.text = currentProfile.number
            binding.textDistrict.text = currentProfile.district
        }
    }
}