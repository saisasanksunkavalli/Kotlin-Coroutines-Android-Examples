package com.mindorks.example.coroutines.github.data.api

import com.mindorks.example.coroutines.github.data.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{username}/repos")
    suspend fun getRepos(@Path("username") username: String): List<Repo>
}