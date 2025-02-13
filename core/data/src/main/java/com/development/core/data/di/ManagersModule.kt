package com.development.core.data.di

import android.content.Context
import com.development.core.data.managers.AndroidEmailManager
import com.development.core.data.managers.AndroidPhoneDialManager
import com.development.core.domain.managers.EmailManager
import com.development.core.domain.managers.PhoneDialManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ManagersModule {
    @Provides
    fun providePhoneDialManager(@ApplicationContext appContext: Context): PhoneDialManager =
        AndroidPhoneDialManager(appContext)

    @Provides
    fun provideEmailManager(@ApplicationContext appContext: Context): EmailManager =
        AndroidEmailManager(appContext)
}
