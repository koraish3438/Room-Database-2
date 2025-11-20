package com.example.roomdatabase2.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.roomdatabase2.database.Profile
import com.example.roomdatabase2.databinding.ActivityUpdateProfileBinding
import com.example.roomdatabase2.viewModel.ProfileViewModel

class UpdateProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var currentProfile: Profile
    private var profileId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUpdateProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ProfileViewModel(application)

        profileId = intent.getIntExtra("profileId", 0)

        viewModel.getAllProfiles().observe(this) { profiles ->
            currentProfile = profiles.find { it.id == profileId } ?: return@observe
            binding.editTextUpdateName.setText(currentProfile.name)
            binding.editTextUpdateEmail.setText(currentProfile.email)
            binding.editTextUpdateNumber.setText(currentProfile.number)
            binding.editTextUpdateDistrict.setText(currentProfile.district)
            binding.editTextUpdateDob.setText(currentProfile.dob)
        }

        binding.btnUpdateProfile.setOnClickListener {
            val updateProfile = currentProfile.copy(
                name = binding.editTextUpdateName.text.toString(),
                email = binding.editTextUpdateEmail.text.toString(),
                number = binding.editTextUpdateNumber.text.toString(),
                dob = binding.editTextUpdateDob.text.toString(),
                district = binding.editTextUpdateDistrict.text.toString()
            )

            viewModel.updateProfile(updateProfile)
            finish()
        }

    }
}