package com.example.whatsappui.data.repository.datasource

import androidx.lifecycle.LiveData
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel

interface LocalDataSource {

    // Contacts
    fun getAllContacts(): LiveData<List<ContactsModel>>

    suspend fun insertContact(contactsModel: ContactsModel)

    suspend fun updateContact(contactsModel: ContactsModel)

    // Inbox
    suspend fun insertMessageToInbox(messagesModel: MessagesModel)

    fun getMessagesByPersonId(personID: Int): LiveData<List<MessagesModel>>
}
