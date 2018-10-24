package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.activity

import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.diegojosuepachecorosas.demogithub.R
import com.example.diegojosuepachecorosas.demogithub.core.platform.BaseActivity
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.adapter.RVReposAdapter
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel.ReposViewState
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class RepoActivity : BaseActivity() {

    companion object {
        fun newInstance(context: Context) = Intent(context, RepoActivity::class.java)
    }

    private val viewModel by lazy {
        getViewModel() as RepoViewModel
    }

    private lateinit var adapter: RVReposAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = RVReposAdapter()
        rvSearch.adapter = adapter

        etSearchQuery.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                //actionId : el accionId de la accion que se va a realizar
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    viewModel.loadRepos(etSearchQuery.text.toString())
                    return true
                }
                return false
            }
        })


        viewModel.state.observe(this, Observer {
            it?.run {
                when (this) {
                    ReposViewState.Loading -> {
                        progressBar.visibility = View.VISIBLE
                        tvMessage.visibility = View.GONE
                    }
                    is ReposViewState.Error -> {
                        progressBar.visibility = View.GONE
                        tvMessage.text = reason
                        tvMessage.setTextColor(Color.RED)
                        tvMessage.visibility = View.VISIBLE
                    }
                    is ReposViewState.Success -> {
                        progressBar.visibility = View.GONE
                        tvMessage.visibility = View.GONE
                        tvCountRepos.text = totalcount.toString()
                        adapter.addRepos(repos)


                    }
                    is ReposViewState.noRepos -> {
                        progressBar.visibility = View.GONE
                        tvMessage.visibility = View.VISIBLE
                        tvMessage.text = getString(R.string.reposearch_state_emptyrepos)
                        tvMessage.setTextColor(Color.BLACK)
                    }
                }
            }
        }
        )

    }
}
