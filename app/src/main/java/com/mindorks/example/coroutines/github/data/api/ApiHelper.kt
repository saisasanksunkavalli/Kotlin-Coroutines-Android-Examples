package com.mindorks.example.coroutines.github.data.api

import com.mindorks.example.coroutines.github.data.model.Repo

interface ApiHelper {

    suspend fun getRepos(username: String): List<Repo>
}