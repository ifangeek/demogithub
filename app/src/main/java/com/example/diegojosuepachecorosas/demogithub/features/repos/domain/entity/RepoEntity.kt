package com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity

data class RepoEntity(
        val id: Int,
        val name: String,
        val fullName: String,
        val private: Boolean?,
        val html_url: String?,
        val description: String?,
        val size: Int?,
        val language: String?,
        val score: Double?
)