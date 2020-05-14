package com.example.linguagensapp.ui.Fragments.detailActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.linguagensapp.R
import com.example.linguagensapp.ui.Adapter.ProjectAdapter
import com.example.linguagensapp.ui.viewmodel.ProjectViewModel
import kotlinx.android.synthetic.main.fragment_projects.*

class ProjectFragment(s: String?): Fragment() {
    private val viewModel: ProjectViewModel by lazy {
        ViewModelProvider(this).get(ProjectViewModel::class.java)
    }

    val s = s

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(
            R.layout.fragment_projects,
            container,
            false
        )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.state.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is ProjectViewModel.State.StateLoading ->{
                    progressLayout.visibility = View.VISIBLE
                }
                is ProjectViewModel.State.StateLoaded ->{
                    progressLayout.visibility = View.GONE
                    val projAdapter = ProjectAdapter(state.list)
                    projectView.layoutManager = LinearLayoutManager(requireContext())
                    projectView.adapter = projAdapter
                }
                is ProjectViewModel.State.StateError ->{
                    progressLayout.visibility = View.GONE
                    if (!state.hasConsumed) {
                        Toast.makeText(
                            requireContext(),
                            R.string.error_load_proj, Toast.LENGTH_LONG
                        )
                    }
                }
            }
        }
        )
        viewModel.loadProjs(s)

}
}