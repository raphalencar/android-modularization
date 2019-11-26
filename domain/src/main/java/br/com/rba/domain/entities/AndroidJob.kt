package br.com.rba.domain.entities

data class AndroidJob(
    val title: String,
    val experienceTimeRequired: Int,
    val native: Boolean,
    val country: String
)