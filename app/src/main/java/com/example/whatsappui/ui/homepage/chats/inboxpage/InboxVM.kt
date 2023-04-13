package com.example.whatsappui.ui.homepage.chats.inboxpage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.whatsappui.data.model.messagespage.MessagesModel
import com.example.whatsappui.data.repository.datasource.LocalDataSource
import kotlinx.coroutines.launch

class InboxVM(
    private val app: Application,
    private val localDataSource: LocalDataSource,
) : AndroidViewModel(app) {

    suspend fun insertMessageToInbox(messagesModel: MessagesModel) {
        viewModelScope.launch {
            localDataSource.insertMessageToInbox(messagesModel)
        }
    }

    fun getMessagesByPersonId(personID: Int): LiveData<List<MessagesModel>> =
        localDataSource.getMessagesByPersonId(personID)
}
