package br.com.rba.androidmodularization.feature.list

import androidx.lifecycle.MutableLiveData
import br.com.rba.androidmodularization.feature.viewmodel.BaseViewModel
import br.com.rba.androidmodularization.feature.viewmodel.StateMachineSingle
import br.com.rba.androidmodularization.feature.viewmodel.ViewState
import br.com.rba.domain.entities.AndroidJob
import br.com.rba.domain.usecases.GetJobsUseCases
import io.reactivex.Scheduler
import io.reactivex.rxkotlin.plusAssign

class AndroidJobListViewModel(
    val useCase: GetJobsUseCases,
    val uiScheduler: Scheduler
) : BaseViewModel() {

    val state = MutableLiveData<ViewState<List<AndroidJob>>>().apply {
        value = ViewState.Loading
    }

    fun getJobs(forceUpdate: Boolean = false) {
        disposables += useCase.execute(forceUpdate = forceUpdate)
            .compose(StateMachineSingle())
            .observeOn(uiScheduler)
            .subscribe(
                {
                    // onSuccess
                    state.postValue(it)
                },
                {
                    // onError já retorna na StateMachine
                }
            )
    }

    fun onTryAgainRequired() {
        getJobs(forceUpdate = true)
    }
}