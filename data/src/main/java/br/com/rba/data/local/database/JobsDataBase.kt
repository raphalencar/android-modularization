package br.com.rba.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.rba.data.local.model.AndroidJobCache

/**
 *
 * Classe que cria o banco de dados
 * Setando o jobsDao como meio de acesso aos dados do banco
 * **/
@Database(version = 1, entities = [AndroidJobCache::class])
abstract class JobsDataBase :  RoomDatabase() {

    abstract fun jobsDao() : JobsDao

    companion object {
        fun createDataBase(context: Context) : JobsDao {
            return Room
                .databaseBuilder(context, JobsDataBase::class.java, "Jobs.db")
                .build()
                .jobsDao()
        }
    }
}