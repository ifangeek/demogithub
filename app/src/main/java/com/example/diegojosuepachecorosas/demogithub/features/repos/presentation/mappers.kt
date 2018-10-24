package com.example.diegojosuepachecorosas.demogithub.features.repos.presentation

import com.example.diegojosuepachecorosas.demogithub.core.mapper.Mapper
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ReposVM
import com.example.diegojosuepachecorosas.demogithub.features.repos.presentation.model.ResultVM


object ResultVMMapper : Mapper<ResultEntity, ResultVM> {
    override fun map(origin: ResultEntity): ResultVM {
        return ResultVM(
                origin.totalCount,
                origin.result.map(RepoVMMapper::map) as ArrayList<ReposVM>
        )
    }


}

object RepoVMMapper : Mapper<RepoEntity, ReposVM> {
    override fun map(origin: RepoEntity): ReposVM {
        return ReposVM(
                origin.id,
                origin.name,
                origin.fullName,
                origin._private,
                origin.description,
                origin.updateAt,
                origin.size,
                origin.stargazersCount,
                origin.language,
                origin.hasWiki,
                origin.archived,
                origin.score
        )
    }

}

