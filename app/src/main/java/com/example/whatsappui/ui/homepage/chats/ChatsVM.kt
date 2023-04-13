package com.example.whatsappui.ui.homepage.chats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel
import com.example.whatsappui.data.repository.datasource.LocalDataSource
import kotlinx.coroutines.launch

class ChatsVM(
    private val app: Application,
    private val localDataSource: LocalDataSource,
) : AndroidViewModel(app) {

    fun fetchContacts(): LiveData<List<ContactsModel>> =
        localDataSource.getAllContacts()

    fun insertContact(contactsModel: ContactsModel) {
        viewModelScope.launch {
            localDataSource.insertContact(contactsModel)
        }
    }

    fun updateContact(contactsModel: ContactsModel) {
        viewModelScope.launch {
            localDataSource.updateContact(contactsModel)
        }
    }

    fun getLastMessagesByPersonId(personId: Int): LiveData<List<MessagesModel>> =
        localDataSource.getMessagesByPersonId(personId)
}
