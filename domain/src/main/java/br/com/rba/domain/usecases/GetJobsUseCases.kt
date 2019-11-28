package br.com.rba.domain.usecases

import br.com.rba.domain.entities.AndroidJob
import br.com.rba.domain.repository.AndroidJobsRepository
import io.reactivex.Scheduler
import io.reactivex.Single

/**
 * Usecase: Retornar a lista de AndroidJobs
 * Duas dependências:
 * 1) Repositorio de onde será solicitada a lista
 * 2) Scheduler para informar a thread onde a chamada vai ser assinada
 **/
class GetJobsUseCases(
    private val repository: AndroidJobsRepository,
    private val scheduler: Scheduler
) {

    fun execute(forceUpdate: Boolean) : Single<List<AndroidJob>> {
        return repository.getJobs(forceUpdate).subscribeOn(scheduler)
    }
}