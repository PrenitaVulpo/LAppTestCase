package com.example.linguagensapp.ui.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_lang.view.*

class LangCardAdapter(
    val list: List<LanguageModel>,
    val itemCallback: (LanguageModel) -> Unit
): RecyclerView.Adapter<LangCardAdapter.LangVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LangVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lang, parent, false)

        return LangVH(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LangVH, position: Int) {
        val lang = list[position]
        holder.run {
            if (lang.image == null){
                Picasso.get()
                    .load(R.drawable.logo_no_logo)
                    .into(imgLang)
            } else {
                Picasso.get()
                    .load(lang.image)
                    .into(imgLang)
            }
            txtName.text = lang.name

            itemView.setOnClickListener{
                itemCallback(lang)


            }
        }
    }

    inner class LangVH(parent: View): RecyclerView.ViewHolder(parent){
        val imgLang: ImageView = parent.imgLang
        val txtName: TextView = parent.langName
    }
}