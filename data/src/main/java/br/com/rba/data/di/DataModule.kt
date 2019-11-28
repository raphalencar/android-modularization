package br.com.rba.data.di

import br.com.rba.data.AndroidJobsRepositoryImpl
import br.com.rba.domain.repository.AndroidJobsRepository
import org.koin.dsl.module

/**
 *
 * Dependência do repository
 *
 * **/
val repositoryModule = module {
    factory<AndroidJobsRepository> {
        AndroidJobsRepositoryImpl(
            jobsCacheDataSource = get(),
            remoteDataSource = get()
        )
    }
}

val dataModules = listOf(remoteDataSourceModule, repositoryModule, cacheDataModule)