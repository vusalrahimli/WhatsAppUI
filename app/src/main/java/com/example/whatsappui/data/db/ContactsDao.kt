package com.example.whatsappui.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel

@Dao
interface ContactsDao {

    // Contacts
    @Query("SELECT * FROM contacts ORDER BY id")
    fun getAllContacts(): LiveData<List<ContactsModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertContact(contactsModel: ContactsModel)

    @Update
    suspend fun updateContact(contactsModel: ContactsModel)

    // Inbox
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMessageToInbox(messagesModel: MessagesModel)

    @Query("SELECT * FROM messages WHERE personId=:personID ORDER BY dateMessage")
    fun getMessagesByPersonId(personID: Int): LiveData<List<MessagesModel>>

    @Query("SELECT * FROM messages ORDER BY dateMessage DESC LIMIT 1")
    fun getLastMessageByPersonId(personID: Int): LiveData<List<MessagesModel>>
}
