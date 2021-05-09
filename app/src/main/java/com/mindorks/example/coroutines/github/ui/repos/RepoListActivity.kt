package com.mindorks.example.coroutines.github.ui.repos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindorks.example.coroutines.R
import com.mindorks.example.coroutines.github.data.model.Repo
import kotlinx.android.synthetic.main.activity_repo_list.*

class RepoListActivity : AppCompatActivity() {
    private lateinit var viewModel: RepoListViewModel
    private lateinit var adapter: RepoListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)
        viewModel = ViewModelProviders.of(this).get(RepoListViewModel::class.java)
        setupUI()
        setupObserver()
    }


    private fun setupUI() {
        rv_repos_list.layoutManager = LinearLayoutManager(this)
        adapter =
            RepoListAdapter(
                arrayListOf()
            )
        rv_repos_list.addItemDecoration(
            DividerItemDecoration(
                rv_repos_list.context,
                (rv_repos_list.layoutManager as LinearLayoutManager).orientation
            )
        )
        rv_repos_list.adapter = adapter
    }

    private fun setupObserver() {
        viewModel.getReposFromApi().observe(this, {
            renderRepoList(it)
        })
    }

    private fun renderRepoList(repos: List<Repo>) {
        adapter.addData(repos)
    }

}