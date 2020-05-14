package com.example.linguagensapp.ui.Fragments.detailActivity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.linguagensapp.Models.LanguageModel
import com.example.linguagensapp.R
import com.example.linguagensapp.repository.LangRepository
import com.example.linguagensapp.ui.viewmodel.DetailViewModel
import com.example.linguagensapp.ui.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_lang.*
import kotlinx.android.synthetic.main.item_lang.langName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class DetailFragment (lang: LanguageModel?): Fragment(){
    private val job = Job()
    private val coroutineScope = CoroutineScope(job + Dispatchers.Main)

    private val viewModel: DetailViewModel by lazy{
        ViewModelProvider(
            this,
            ViewModelFactory(
                LangRepository(context!!)
            )
        ).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(
            R.layout.fragment_detail,
            container,
            false
        )

    val language = lang

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        language?.run {
            langName.text = language.name
            //refatorar if statements em algo mais elegante
            if (language.creators.isNullOrEmpty() == false){
                langCreators.text = language.creators.toString()
            }
            if (language.creators.isNullOrEmpty() == false){
                langCreators.text = language.creators.toString()
            }
            if (language.release_date.isNullOrEmpty() == false){
                langReleaseDate.text = language.release_date.toString()
            }
            if (language.typing_discipline.isNullOrEmpty() == false){
                langTypingDiscipline.text = language.typing_discipline.toString()
            }
            viewModel.onCreate(language)
            viewModel.isFavorite.observe(viewLifecycleOwner,
                Observer {isFavorite ->
                    if (isFavorite){
                        buttonFav.text = R.string.remover_entrada.toString()
                        buttonFav.setBackgroundColor(Color.CYAN)
                        buttonFav.setOnClickListener{
                            viewModel.removeToFavorites(language)
                        }
                        Toast.makeText(getActivity(), "Entrada removida", Toast.LENGTH_SHORT).show()
                        Log.i("Entrada Removida", "teste")
                    } else {
                        buttonFav.text = R.string.adicionar_entrada.toString()
                        buttonFav.setBackgroundColor(Color.GREEN)
                        buttonFav.setOnClickListener{
                            viewModel.saveToFavorite(language)
                        }
                        Toast.makeText(getActivity(), "Entrada adicionada", Toast.LENGTH_SHORT).show()
                        Log.i("Entrada Adicionada", "teste")
                    }
                }
            )
        }
    }

}