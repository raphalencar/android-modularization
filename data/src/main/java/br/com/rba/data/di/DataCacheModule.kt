package br.com.rba.data.di

import br.com.rba.data.local.database.JobsDataBase
import br.com.rba.data.local.source.JobsCacheDataSource
import br.com.rba.data.local.source.JobsCacheSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 *
 * Gerir as dependências de cache
 *
 * **/
val cacheDataModule = module {
    single { JobsDataBase.createDataBase(androidContext()) }
    factory<JobsCacheDataSource> { JobsCacheSourceImpl(jobsDao = get()) }
}