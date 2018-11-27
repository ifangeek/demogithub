package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model

data class ReposVM(
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