package br.com.rba.domain.repository

import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Single

/**
 *
 * Interface de comunicação com o modulo data
 * A implementação fica em data
 *
 * **/
interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean): Single<List<AndroidJob>>
}