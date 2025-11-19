package com.example.roomdatabase2.database

import androidx.lifecycle.LiveData

class ProfileRepository(private val profileDao: ProfileDao) {
    fun getAllProfiles(): LiveData<List<Profile>> {
        return profileDao.getAllProfiles()
    }

    suspend fun insert(profile: Profile) {
        profileDao.insert(profile)
    }

    suspend fun update(profile: Profile) {
        profileDao.update(profile)
    }

    suspend fun delete(profile: Profile) {
        profileDao.delete(profile)
    }
}