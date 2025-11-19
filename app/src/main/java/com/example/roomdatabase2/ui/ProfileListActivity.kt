package com.example.roomdatabase2.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase2.adapter.ProfileAdapter
import com.example.roomdatabase2.databinding.ActivityProfileListBinding
import com.example.roomdatabase2.viewModel.ProfileViewModel

class ProfileListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileListBinding
    private lateinit var profileViewModel: ProfileViewModel
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileViewModel = ProfileViewModel(application)
        

        profileAdapter = ProfileAdapter(
            emptyList(),
            onItemClicked = { profile ->
                val intent = Intent(this, ProfileDetailsActivity::class.java)
                intent.putExtra("profileId", profile.id)
                startActivity(intent)
            },
            onEditClick = { profile ->
                val intent = Intent(this, UpdateProfileActivity::class.java)
                intent.putExtra("profileId", profile.id)
                startActivity(intent)
            },
            onDeleteClick = { profile ->
                profileViewModel.deleteProfile(profile)
            }
        )

        binding.recyclerViewProfiles.adapter = profileAdapter
        binding.recyclerViewProfiles.layoutManager = LinearLayoutManager(this)

        profileViewModel.getAllProfiles().observe(this) { profile ->
            profileAdapter.updateList(profile)
        }

        binding.btnAddProfile.setOnClickListener { 
            startActivity(Intent(this, AddProfileActivity::class.java))
        }
    }
}