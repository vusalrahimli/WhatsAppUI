package com.example.whatsappui.di

import android.content.Context
import androidx.room.Room
import com.example.whatsappui.data.db.ContactsDB
import com.example.whatsappui.data.other.Constants
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { provideContactsDatabase(androidContext()) }
    single { provideContactsDao(get()) }
}

fun provideContactsDatabase(context: Context) = Room.databaseBuilder(
    context,
    ContactsDB::class.java,
    Constants.DB_NAME,
).allowMainThreadQueries().build()

fun provideContactsDao(
    database: ContactsDB,
) = database.contactsDao()
