package com.example.linguagensapp.ui.Adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.linguagensapp.ui.Fragments.CardViewFragment
import com.example.linguagensapp.ui.Fragments.FavoriteFragment

class LangAdapter(f: FragmentActivity): FragmentStateAdapter(f) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment =
        when (position){
            0 -> {
                Log.i("teste", "FragmentCalled")
                CardViewFragment()
            }
            else -> {FavoriteFragment()}
        }
}