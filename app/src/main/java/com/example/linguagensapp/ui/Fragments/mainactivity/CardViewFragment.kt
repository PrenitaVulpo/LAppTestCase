package com.example.linguagensapp.ui.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.R
import com.example.linguagensapp.ui.Adapter.LangAdapter
import com.example.linguagensapp.ui.Adapter.LangCardAdapter
import com.example.linguagensapp.ui.MainActivity
import com.example.linguagensapp.ui.viewmodel.LangViewModel
import kotlinx.android.synthetic.main.fragment_lang_list.*

class CardViewFragment: Fragment() {

    private val viewModel: LangViewModel by lazy {
        ViewModelProvider(this).get(LangViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_lang_list, container,false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is LangViewModel.Estado.StateLoading ->{
                    progressLayout.visibility = View.VISIBLE
                }
                is LangViewModel.Estado.StateLoaded ->{
                    progressLayout.visibility = View.GONE
                    val langAdapter = LangCardAdapter(state.list, this@CardViewFragment::onItemClick)
                    rView.layoutManager = LinearLayoutManager(requireContext())
                    rView.adapter = langAdapter
                }
                is LangViewModel.Estado.StateError ->{
                    progressLayout.visibility = View.GONE
                    if (!state.hasConsumed) {
                        Toast.makeText(
                            requireContext(),
                            R.string.error_load_item, Toast.LENGTH_LONG
                        )
                    }
                }
            }
        })
        viewModel.loadLangs()
    }
    private fun onItemClick(item: LanguageModel){
        MainActivity.openWithItem(requireContext(), item)
    }

}