package br.com.rba.androidmodularization.feature.main

import br.com.rba.androidmodularization.feature.viewmodel.BaseViewModel
import androidx.lifecycle.MutableLiveData


class MainViewModel : BaseViewModel() {

    val showAndroidJobsLiveData = MutableLiveData<Boolean>()
    val outAppLiveData = MutableLiveData<Boolean>()

    fun onShowAndroidJobsRequire() {
        showAndroidJobsLiveData.postValue(true)
    }

    fun onOutAppLiveData() {
        outAppLiveData.postValue(true)
    }
}