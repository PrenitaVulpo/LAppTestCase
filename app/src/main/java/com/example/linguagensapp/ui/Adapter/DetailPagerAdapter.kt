package com.example.linguagensapp.ui.Adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.ui.Fragments.detailActivity.DetailFragment
import com.example.linguagensapp.ui.Fragments.detailActivity.ProjectFragment


class DetailPagerAdapter(f: FragmentActivity, lang: LanguageModel?): FragmentStateAdapter(f) {
    override fun getItemCount(): Int = 2
    val l = lang
    override fun createFragment(position: Int): Fragment =
        when (position){
            0 -> {
                Log.i("teste", "FragmentCalled")
                DetailFragment(l)
            }
            else -> {
                ProjectFragment(l?.name)
            }
        }
}