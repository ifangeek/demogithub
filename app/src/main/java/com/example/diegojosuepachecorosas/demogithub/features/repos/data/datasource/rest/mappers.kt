package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest

import com.example.diegojosuepachecorosas.demogithub.core.mapper.Mapper
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity

object ResultDataMapper : Mapper<ResultResponseData, ResultEntity> {
    override fun map(origin: ResultResponseData): ResultEntity {
        return ResultEntity(
                origin.totalCount,
                origin.result?.map(RepoDataMapper::map) as ArrayList<RepoEntity>
        )
    }



    object RepoDataMapper : Mapper<RepoResponseData, RepoEntity> {
        override fun map(origin: RepoResponseData): RepoEntity {
            return RepoEntity(
                    origin.id,
                    origin.name,
                    origin.fullName,
                    origin._private,
                    origin.description,
                    origin.updatedAt,
                    origin.size,
                    origin.stargazersCount,
                    origin.language,
                    origin.hasWiki,
                    origin.archived,
                    origin.score
            )
        }


    }
}