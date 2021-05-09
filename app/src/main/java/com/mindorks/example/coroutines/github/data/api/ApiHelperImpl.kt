package com.mindorks.example.coroutines.github.data.api


class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override suspend fun getRepos(username: String) = apiService.getRepos(username)
}