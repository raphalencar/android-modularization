package br.com.rba.data.local.source

import br.com.rba.data.local.database.JobsDao
import br.com.rba.data.local.mapper.AndroidJobCacheMapper
import br.com.rba.domain.entities.AndroidJob
import io.reactivex.Single

class JobsCacheSourceImpl(private val jobsDao: JobsDao) : JobsCacheDataSource {

    override fun getJobs(): Single<List<AndroidJob>> {
        return jobsDao.getJobs()
            .map { AndroidJobCacheMapper.map(it) }
    }

    override fun insertData(list: List<AndroidJob>) {
        jobsDao.insertAll(AndroidJobCacheMapper.mapJobsToCache(list))
    }

    override fun updateData(list: List<AndroidJob>) {
        jobsDao.updateData(AndroidJobCacheMapper.mapJobsToCache(list))
    }
}