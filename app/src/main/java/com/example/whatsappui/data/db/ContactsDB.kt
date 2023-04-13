package com.example.whatsappui.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel

@Database(
    entities = [
        ContactsModel::class,
        MessagesModel::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters
abstract class ContactsDB : RoomDatabase() {
    abstract fun contactsDao(): ContactsDao
}
