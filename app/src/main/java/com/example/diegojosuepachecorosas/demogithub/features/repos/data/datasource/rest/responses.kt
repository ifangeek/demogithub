package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest

import com.google.gson.annotations.SerializedName

data class ResultResponseData(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("items")
        val result: ArrayList<RepoResponseData>? = null
)

data class RepoResponseData(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("full_name")
        val fullName: String
    /*    @SerializedName("private")
        val _private: Boolean,
        @SerializedName("description")
        val description: String,
        @SerializedName("updated_at")
        val updatedAt: String,
        @SerializedName("size")
        val size: Int,
        @SerializedName("stargazers_count")
        val stargazersCount: Int,
        @SerializedName("language")
        val language: String,
        @SerializedName("has_wiki")
        val hasWiki: Boolean,
        @SerializedName("archived")
        val archived: Boolean,
        @SerializedName("score")
        val score: Double*/
)