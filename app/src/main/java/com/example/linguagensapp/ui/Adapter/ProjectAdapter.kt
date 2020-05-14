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

class ProjectAdapter(val list: List<ProjectModel>): RecyclerView.Adapter<ProjectAdapter.ProjVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_project, parent, false)

        return ProjVH(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ProjVH, position: Int) {
        val proj = list[position]
        holder.run{
            Picasso.get()
                .load(proj.avatar)
                .into(authorImg)
            projectTitle.text = proj.repo.name
            projectDescription.text = proj.repo.description
        }
    }

    inner class ProjVH(parent: View): RecyclerView.ViewHolder(parent){
        val authorImg: ImageView = parent.authorImg
        val projectTitle: TextView = parent.projectTitle
        val projectDescription: TextView = parent.projectDescription
    }
}