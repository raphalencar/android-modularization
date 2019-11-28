package br.com.rba.data.remote.source

import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Single

/**
 *
 * Interface que vai solicitar dados do backend
 *
 * **/
interface RemoteDataSource {
    // retorna a lista de AndroidJobs, mapeadas do backend
    fun getJobs(): Single<List<AndroidJob>>
}