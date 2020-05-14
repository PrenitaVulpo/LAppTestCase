package com.example.linguagensapp.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.Models.ProjectModel
import com.example.linguagensapp.R
import com.example.linguagensapp.ui.Adapter.LangAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter = LangAdapter(this)
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
    companion object {
        //private const val ITEM_EXTRA = "extra"
        fun openWithItem(context: Context, item: LanguageModel) {
            val intencao = Intent(context, DetailActivity::class.java)
            CoroutineScope(Dispatchers.IO).launch {

            }
            intencao.putExtra("extra", item)
            context.startActivity(intencao)
        }
    }
}
