package br.com.rba.data.remote.source

import br.com.rba.data.remote.api.ServerApi
import br.com.rba.data.remote.mapper.AndroidJobMapper
import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Single

/**
 *
 * Implementação da interface RemoteDataSource
 *
 * **/
class RemoteDataSourceImpl(private val serverApi: ServerApi) : RemoteDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return serverApi.fetchJobs().map { AndroidJobMapper.map(it) }
    }
}