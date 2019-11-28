package br.com.rba.androidmodularization.di

import br.com.rba.androidmodularization.feature.list.AndroidJobListViewModel
import br.com.rba.androidmodularization.feature.list.AndroidJobsAdapter
import br.com.rba.androidmodularization.feature.main.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *
 * Prover tudo que a view e os viewmodels precisam
 *
 * **/
val presentationModule = module {

    factory { AndroidJobsAdapter() }

    viewModel { MainViewModel() }

    viewModel {
        AndroidJobListViewModel(
            useCase = get(),
            uiScheduler = AndroidSchedulers.mainThread()
        )
    }
}