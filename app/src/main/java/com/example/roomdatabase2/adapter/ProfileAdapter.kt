package com.example.roomdatabase2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase2.database.Profile
import com.example.roomdatabase2.databinding.ProfileItemLayoutBinding

class ProfileAdapter(private var profile: List<Profile>,
                     private val onItemClicked: (Profile) -> Unit,
                     private val onEditClick: (Profile) -> Unit,
                     private val onDeleteClick: (Profile) -> Unit
): RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    fun updateList(newList: List<Profile>) {
        profile = newList
        notifyDataSetChanged()
    }

    inner class ProfileViewHolder(val binding: ProfileItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
       val binding = ProfileItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) { 
        val currentProfile = profile[position]
        holder.binding.tvName.text = currentProfile.name
        holder.binding.tvEmail.text = currentProfile.email
        holder.binding.tvNumber.text = currentProfile.number
        holder.binding.tvDob.text = currentProfile.dob
        holder.binding.tvDistrict.text = currentProfile.district

        holder.binding.root.setOnClickListener {
            onItemClicked(currentProfile)
        }

        holder.binding.btnEdit.setOnClickListener {
            onEditClick(currentProfile)
        }

        holder.binding.btnDelete.setOnClickListener {
            onDeleteClick(currentProfile)
        }  
    }

    override fun getItemCount(): Int = profile.size
}