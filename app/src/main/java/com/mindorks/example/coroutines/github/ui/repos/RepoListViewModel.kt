package com.mindorks.example.coroutines.github.ui.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mindorks.example.coroutines.github.data.api.ApiHelperImpl
import com.mindorks.example.coroutines.github.data.api.RetrofitBuilder
import com.mindorks.example.coroutines.github.data.model.Repo
import kotlinx.coroutines.launch

class RepoListViewModel() : ViewModel() {

    private val repos = MutableLiveData<List<Repo>>()

    init {
        getRepos("saisasanksunkavalli")
    }

    fun getRepos(username: String) {
        viewModelScope.launch {
            try {
                val reposFromApi = ApiHelperImpl(RetrofitBuilder.apiService).getRepos(username)
                repos.postValue(reposFromApi)
            } catch (e: Exception) {
                print("Exception in Api call ${e.message}")
            }
        }
    }

    fun getReposFromApi(): LiveData<List<Repo>> {
        return repos
    }
}