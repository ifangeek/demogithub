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
<<<<<<< HEAD
        val fullName: String,
        @SerializedName("private")
        val private: Boolean?,
        @SerializedName("html_url")
        val html_url : String?,
=======
        val fullName: String
    /*    @SerializedName("private")
        val _private: Boolean,
>>>>>>> 02ef840fac80d3f96d19ea03c8f6ccc28aed5fb6
        @SerializedName("description")
        val description: String?,
        @SerializedName("size")
        val size: Int?,
        @SerializedName("language")
        val language: String?,
        @SerializedName("score")
<<<<<<< HEAD
        val score: Double?
=======
        val score: Double*/
>>>>>>> 02ef840fac80d3f96d19ea03c8f6ccc28aed5fb6
)