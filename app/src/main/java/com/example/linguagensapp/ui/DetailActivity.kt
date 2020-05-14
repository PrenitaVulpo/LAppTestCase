package com.example.linguagensapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.R
import com.example.linguagensapp.ui.Adapter.DetailPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.pager as pager1
import kotlinx.android.synthetic.main.activity_main.tabs as tabs1

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val item = intent.getParcelableExtra<LanguageModel>("extra")
        pager.adapter = DetailPagerAdapter(this, item)
        if (pager.adapter != null){
            Log.i("teste", "AdapterCalled")
        }
        TabLayoutMediator(tabs, pager) { tab, position ->
            tab.setText(
                if (position == 0) {
                    R.string.tab_list
                } else {
                    R.string.tab_favorites
                }
            )

        }.attach()

    }
}