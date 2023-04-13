package com.example.whatsappui.data.repository.datasourceimpl

import androidx.lifecycle.LiveData
import com.example.whatsappui.data.db.ContactsDao
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel
import com.example.whatsappui.data.repository.datasource.LocalDataSource

class LocalDataSourceImpl(private val contactsDao: ContactsDao) : LocalDataSource {

    // Messages
    override fun getAllContacts(): LiveData<List<ContactsModel>> = contactsDao.getAllContacts()

    override suspend fun insertContact(contactsModel: ContactsModel) =
        contactsDao.insertContact(contactsModel)

    override suspend fun updateContact(contactsModel: ContactsModel) =
        contactsDao.updateContact(contactsModel)

    // Inbox
    override suspend fun insertMessageToInbox(messagesModel: MessagesModel) =
        contactsDao.insertMessageToInbox(messagesModel)

    override fun getMessagesByPersonId(personID: Int): LiveData<List<MessagesModel>> =
        contactsDao.getMessagesByPersonId(personID)

    override fun getLastMessageByPersonId(personID: Int): LiveData<List<MessagesModel>> =
        contactsDao.getLastMessageByPersonId(personID)
}
