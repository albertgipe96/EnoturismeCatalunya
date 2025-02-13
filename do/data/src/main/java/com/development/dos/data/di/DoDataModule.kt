package com.development.dos.data.di

import android.content.Context
import com.development.core.data.di.IO
import com.development.dos.data.DefaultCellarRepository
import com.development.dos.data.DefaultDoRepository
import com.development.dos.data.datasource.cellars.CellarsDataSource
import com.development.dos.data.datasource.cellars.LocalCellarsDataSource
import com.development.dos.data.datasource.denoms.DenomsDataSource
import com.development.dos.data.datasource.denoms.LocalDenomsDataSource
import com.development.dos.domain.CellarRepository
import com.development.dos.domain.DoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DoDataModule {
    @Provides
    fun providesDoRepository(
        denomsDataSource: DenomsDataSource,
        @IO dispatcher: CoroutineDispatcher
    ): DoRepository = DefaultDoRepository(denomsDataSource, dispatcher)

    @Provides
    fun providesDenomsDataSource(@ApplicationContext appContext: Context): DenomsDataSource =
        LocalDenomsDataSource(appContext)

    @Provides
    fun providesCellarsRepository(
        cellarsDataSource: CellarsDataSource,
        @IO dispatcher: CoroutineDispatcher
    ): CellarRepository = DefaultCellarRepository(cellarsDataSource, dispatcher)

    @Provides
    fun providesCellarsDataSource(@ApplicationContext appContext: Context): CellarsDataSource =
        LocalCellarsDataSource(appContext)
}
