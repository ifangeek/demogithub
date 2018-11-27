package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diegojosuepachecorosas.demogithub.R
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ReposVM
import kotlinx.android.synthetic.main.item_repo.view.*

class RVReposAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    //field = data
    var data : List<ReposVM> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    /*fun addRepos(reposVM: List<ReposVM>){
        data.addAll(reposVM)
        notifyDataSetChanged()

    }*/
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as ViewHolder
        holder.bindView(data[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(model: ReposVM) {
            itemView.tvRepoName.text = model.fullName
            itemView.tvLanguage.text = model.language.toString()
        }
    }
}