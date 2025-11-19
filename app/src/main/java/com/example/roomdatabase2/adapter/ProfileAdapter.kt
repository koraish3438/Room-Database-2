package com.example.roomdatabase2.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabase2.database.Profile

class ProfileAdapter(private var profile: Profile,
                     private val onItemClicked: (Profile) -> Unit,
                     private val onEditClick: (Profile) -> Unit,
                     private val onDeleteClick: (Profile) -> Unit
): RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder> {

    inner class ProfileViewHolder {

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProfileViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(
        holder: ProfileViewHolder,
        position: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}