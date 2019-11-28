package br.com.rba.data.remote.mapper

import br.com.rba.data.remote.model.AndroidJobsPayload
import br.com.rba.data.remote.model.JobsPayload
import br.com.rba.domain.entities.AndroidJob

/**
 *
 * Mapper dos dados puros do backend, os payloads, em AndroidJobs que são pedidos pela domain
 *
 * **/
object AndroidJobMapper {

    fun map(payload: JobsPayload) = payload.jobsPayload.map { map(it) }

    private fun map(payload: AndroidJobsPayload) = AndroidJob(
        title = payload.title,
        experienceTimeRequired = payload.requiredExperienceYears,
        native = payload.native,
        country = payload.country
    )
}