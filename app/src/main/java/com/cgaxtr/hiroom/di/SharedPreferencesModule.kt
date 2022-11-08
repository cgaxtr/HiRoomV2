package com.cgaxtr.hiroom.di

import android.content.Context
import com.cgaxtr.hiroom.data.pref.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SharedPreferencesModule {

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): DataStoreRepository =
        DataStoreRepository(context)
}