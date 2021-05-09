package com.mindorks.example.coroutines.github.data.model

import com.google.gson.annotations.SerializedName

data class Repo(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("url")
    val url: String = "",
)
