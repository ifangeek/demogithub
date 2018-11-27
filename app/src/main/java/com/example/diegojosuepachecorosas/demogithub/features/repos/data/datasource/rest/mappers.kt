package com.example.diegojosuepachecorosas.demogithub.features.repos.data.datasource.rest

import com.example.diegojosuepachecorosas.demogithub.core.mapper.Mapper
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.RepoEntity
import com.example.diegojosuepachecorosas.demogithub.features.repos.domain.entity.ResultEntity

object ResultDataMapper : Mapper<ResultResponseData, ResultEntity> {
    override fun map(origin: ResultResponseData): ResultEntity {
        return ResultEntity(
                origin.totalCount,
                origin.result!!.map(RepoDataMapper::map) as ArrayList<RepoEntity>
        )
    }



    object RepoDataMapper : Mapper<RepoResponseData, RepoEntity> {
        override fun map(origin: RepoResponseData): RepoEntity {
            return RepoEntity(
                    origin.id,
                    origin.name,
<<<<<<< HEAD
                    origin.fullName,
                    origin.private,
                    origin.html_url,
                    origin.description,
                    origin.size,
                    origin.language,
                    origin.score
=======
                    origin.fullName
>>>>>>> 02ef840fac80d3f96d19ea03c8f6ccc28aed5fb6
            )
        }


    }
}