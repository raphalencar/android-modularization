package br.com.rba.data.local.source

import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Single


/**
 *
 * Interface utilizada para que o repository possa solicitar os dados da cache
 *
 * **/
interface JobsCacheDataSource {

    fun getJobs(): Single<List<AndroidJob>>
    fun insertData(list: List<AndroidJob>)
    fun updateData(list: List<AndroidJob>)
}