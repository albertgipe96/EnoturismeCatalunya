package com.development.dos.data.di

import android.content.Context
import com.development.dos.data.LocalDoRepository
import com.development.dos.domain.DoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DoDataModule {
    @Provides
    fun providesDoRepository(@ApplicationContext appContext: Context): DoRepository =
        LocalDoRepository(appContext)
}