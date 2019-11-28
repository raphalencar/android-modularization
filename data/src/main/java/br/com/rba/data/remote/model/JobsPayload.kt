package br.com.rba.data.remote.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Dado puro do backend
 *
 * **/
class JobsPayload(
    @SerializedName("jobs") val jobsPayload: List<AndroidJobsPayload>
)

class AndroidJobsPayload(
    @SerializedName("title") val title: String,
    @SerializedName("native") val native: Boolean,
    @SerializedName("required_experience_years") val requiredExperienceYears: Int,
    @SerializedName("country") val country: String
)