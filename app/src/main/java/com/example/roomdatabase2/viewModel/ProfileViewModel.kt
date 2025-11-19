package com.example.roomdatabase2.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase2.database.Profile
import com.example.roomdatabase2.database.ProfileDatabase
import com.example.roomdatabase2.database.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ProfileRepository

    init {
        val profileDao = ProfileDatabase.getDatabase(application).profileDao()
        repository = ProfileRepository(profileDao)
    }

    fun getAllProfiles(): LiveData<List<Profile>> {
        return repository.getAllProfiles()
    }

    fun insertProfile(profile: Profile) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.insert(profile)
        }
    }

    fun updateProfile(profile: Profile) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.insert(profile)
        }
    }

    fun deleteProfile(profile: Profile) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.insert(profile)
        }
    }
}