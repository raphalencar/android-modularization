package br.com.rba.data.local.database

import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import br.com.rba.data.local.model.AndroidJobCache
import io.reactivex.Single

/**
 *
 * Interface de interação com o banco de dados local
 * DAO (Data Access Object)
 *
 * **/
interface JobsDao {

    @Query("SELECT * FROM jobs")
    fun getJobs(): Single<List<AndroidJobCache>>

    @Transaction
    fun updateData(users: List<AndroidJobCache>) {
        deleteAll()
        insertAll(users)
    }

    @Insert
    fun insertAll(users: List<AndroidJobCache>)

    @Query("DELETE FROM jobs")
    fun deleteAll()
}