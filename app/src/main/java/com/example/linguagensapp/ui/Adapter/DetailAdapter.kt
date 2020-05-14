package com.example.linguagensapp.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.linguagensapp.Models.ProjectModel
import com.example.linguagensapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_project.view.*

class DetailAdapter(val list: List<ProjectModel>): RecyclerView.Adapter<DetailAdapter.DetailVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)

        return DetailVH(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: DetailVH, position: Int) {
        val proj = list[position]
        holder.run {
            if (proj.avatar == null){
                Picasso.get()
                    .load(R.drawable.logo_no_logo)
                    .into(authorImg)
            } else {
                Picasso.get()
                    .load(proj.avatar)
                    .into(authorImg)
            }
            projectTitle.text = proj.repo.name
            projectDescription.text = proj.repo.description
        }
    }

    inner class DetailVH(parent: View): RecyclerView.ViewHolder(parent){
        val projectTitle: TextView = parent.projectTitle
        val projectDescription: TextView = parent.projectDescription
        val authorImg: ImageView = parent.authorImg
    }
}