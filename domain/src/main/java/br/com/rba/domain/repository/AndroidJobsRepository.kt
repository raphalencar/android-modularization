package br.com.rba.domain.repository

import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Observable

interface AndroidJobsRepository {
    fun getJobs(forceUpdate: Boolean) : Observable<List<AndroidJob                  >>
}