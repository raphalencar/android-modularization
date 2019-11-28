package br.com.rba.data.remote.api

import br.com.rba.data.remote.model.JobsPayload
import io.reactivex.Single
import retrofit2.http.GET

/**
 *
 * Interface que contém os endPoints
 *
 * **/
interface ServerApi {

    @GET("/android-jobs")
    fun fetchJobs(): Single<JobsPayload>
}