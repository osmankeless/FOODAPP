package com.example.yemekuygulamasi.di

import com.example.yemekuygulamasi.data.repo.YemeklerDaoRepository
import com.example.yemekuygulamasi.retrofit.ApiUtils
import com.example.yemekuygulamasi.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerDaoRepository(ydao:YemeklerDao) : YemeklerDaoRepository {
        return YemeklerDaoRepository(ydao)//var yrepo = YemeklerDaoRepository()
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }

}