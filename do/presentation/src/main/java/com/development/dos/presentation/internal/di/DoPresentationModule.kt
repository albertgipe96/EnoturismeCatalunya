package com.development.dos.presentation.internal.di

import com.development.core.domain.managers.EmailManager
import com.development.core.domain.managers.PhoneDialManager
import com.development.core.domain.usecases.OpenDialUseCase
import com.development.core.domain.usecases.SendEmailUseCase
import com.development.dos.domain.CellarRepository
import com.development.dos.domain.DoRepository
import com.development.dos.domain.usecases.GetDoCellarsUseCase
import com.development.dos.domain.usecases.GetDoDetailUseCase
import com.development.dos.domain.usecases.GetDoListUseCase
import com.development.dos.presentation.internal.mappers.DoUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object DoPresentationModule {
    @Provides
    internal fun providesDoUiMapper(): DoUiMapper = DoUiMapper()

    @Provides
    fun providesGetDoListUseCase(doRepository: DoRepository): GetDoListUseCase {
        return GetDoListUseCase(doRepository)
    }

    @Provides
    fun providesGetDoDetailUseCase(doRepository: DoRepository): GetDoDetailUseCase {
        return GetDoDetailUseCase(doRepository)
    }

    @Provides
    fun providesGetDoCellarsUseCase(cellarRepository: CellarRepository): GetDoCellarsUseCase {
        return GetDoCellarsUseCase(cellarRepository)
    }

    @Provides
    fun providesOpenDialUseCase(phoneDialManager: PhoneDialManager): OpenDialUseCase {
        return OpenDialUseCase(phoneDialManager)
    }

    @Provides
    fun providesSendEmailUseCase(emailManager: EmailManager): SendEmailUseCase {
        return SendEmailUseCase(emailManager)
    }
}
