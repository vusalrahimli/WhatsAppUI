package com.example.whatsappui.di

import com.example.whatsappui.data.db.ContactsDao
import com.example.whatsappui.data.repository.datasource.LocalDataSource
import com.example.whatsappui.data.repository.datasourceimpl.LocalDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single { provideLocalDataSource(get()) }
}

fun provideLocalDataSource(
    contactsDao: ContactsDao,
): LocalDataSource {
    return LocalDataSourceImpl(contactsDao)
}
