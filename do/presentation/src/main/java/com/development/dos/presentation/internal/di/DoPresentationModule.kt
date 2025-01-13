package com.development.dos.presentation.internal.di

import com.development.dos.domain.DoRepository
import com.development.dos.presentation.internal.usecases.GetDoDetailUseCase
import com.development.dos.presentation.internal.usecases.GetDoListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object DoPresentationModule {
    @Provides
    internal fun providesGetDoListUseCase(doRepository: DoRepository): GetDoListUseCase {
        return GetDoListUseCase(doRepository)
    }

    @Provides
    internal fun providesGetDoDetailUseCase(doRepository: DoRepository): GetDoDetailUseCase {
        return GetDoDetailUseCase(doRepository)
    }
}