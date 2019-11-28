package br.com.rba.androidmodularization.feature.viewmodel

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer

/**
 *
 * Gerenciador de estados para mostrar o estado correto na view
 *
 * **/
sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>() // nenhum dado precisa ser emitido
    data class Success<T>(val data: T) : ViewState<T>() // emite o dado da stream
    data class Failed(val throwable: Throwable) : ViewState<Nothing>() // nenhum dado precisa ser emitido, apenas o estado de erro com a exceção
}

class StateMachineSingle<T> : SingleTransformer<T, ViewState<T>> {

    override fun apply(upstream: Single<T>): SingleSource<ViewState<T>> {
        return upstream
            .map {
                ViewState.Success(it) as ViewState<T>
            }
            .onErrorReturn {
                ViewState.Failed(it)
            }
            .doOnSubscribe {
                ViewState.Loading
            }
    }
}