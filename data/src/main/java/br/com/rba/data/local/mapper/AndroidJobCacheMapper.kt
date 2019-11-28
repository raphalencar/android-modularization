package br.com.rba.data.local.mapper

import br.com.rba.data.local.model.AndroidJobCache
import br.com.rba.domain.entities.AndroidJob

/**
 *
 * Mapear os dados para salvar em cache
 * Mapear os dados da cache para serem enviados corretamente
 *
 * **/
object AndroidJobCacheMapper {

    // Mapper Cache -> Domain
    fun map(cacheData: List<AndroidJobCache>) = cacheData.map { map(it) }

    private fun map(cacheData: AndroidJobCache) = AndroidJob(
        title = cacheData.title,
        experienceTimeRequired = cacheData.requiredExperienceYears.toString(),
        native = cacheData.native,
        country = cacheData.country
    )

    // Mapper Domain -> Cache
    fun mapJobsToCache(jobs: List<AndroidJob>) = jobs.map { map(it) }

    private fun map(data: AndroidJob) = AndroidJobCache(
        title = data.title,
        requiredExperienceYears = data.experienceTimeRequired.toInt(),
        native = data.native,
        country = data.country
    )
}