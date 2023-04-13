package com.example.whatsappui.data.model.messagespage

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "messages")
@Parcelize
data class MessagesModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val personId: Int? = null,
    val message: String? = null,
    val dateMessage: String? = null,
) : Parcelable
