package br.com.rba.data

import br.com.rba.data.local.source.JobsCacheDataSource
import br.com.rba.data.remote.source.RemoteDataSource
import br.com.rba.domain.entities.AndroidJob
import br.com.rba.domain.repository.AndroidJobsRepository
import io.reactivex.Single

/**
 *
 * Implementação de AndroidJobsRepository da domain dentro do modulo data
 *
 * **/
class AndroidJobsRepositoryImpl(
    private val jobsCacheDataSource: JobsCacheDataSource,
    private val remoteDataSource: RemoteDataSource
) : AndroidJobsRepository {

    override fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>> {
        return if (forceUpdate)
            getJobsRemote(forceUpdate)
        else
            jobsCacheDataSource.getJobs().flatMap { listJobs ->
                when {
                    listJobs.isEmpty() -> getJobsRemote(false)
                    else -> Single.just(listJobs)
                }
            }
    }

    private fun getJobsRemote(isUpdate: Boolean): Single<List<AndroidJob>> {
        return remoteDataSource.getJobs().flatMap { listJobs ->
            if (isUpdate)
                jobsCacheDataSource.updateData(listJobs)
            else
                jobsCacheDataSource.insertData(listJobs)

            Single.just(listJobs)
        }
    }
}