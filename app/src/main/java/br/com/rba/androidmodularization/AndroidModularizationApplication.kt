package br.com.rba.androidmodularization

import android.app.Application
import br.com.rba.androidmodularization.di.presentationModule
import br.com.rba.data.di.dataModules
import br.com.rba.domain.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndroidModularizationApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidModularizationApplication)

            modules(domainModule + dataModules + listOf(presentationModule))
        }
    }
}