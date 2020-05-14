package com.example.linguagensapp.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.R
import com.example.linguagensapp.repository.LangRepository
import com.example.linguagensapp.ui.Adapter.LangCardAdapter
import com.example.linguagensapp.ui.viewmodel.LangFavViewModel
import com.example.linguagensapp.ui.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lang_list.*


class FavoriteFragment(): Fragment() {

    private val viewModel: LangFavViewModel by lazy{
        ViewModelProvider(
            this,
            ViewModelFactory(
                LangRepository(requireContext())
            )
        ).get(LangFavViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? = inflater.inflate( R.layout.fragment_lang_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.favLangs.observe(
            viewLifecycleOwner,
            Observer {langList ->
                val langAdapter = LangCardAdapter(
                    langList, this@FavoriteFragment::onVolumeClick)
                rView.layoutManager = LinearLayoutManager(requireContext())
                rView.adapter = langAdapter

            }
        )
    }


    private fun onVolumeClick(lang: LanguageModel){
        //TODO
    }


}