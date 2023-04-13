package com.example.whatsappui.data.model.homepage

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "contacts")
@Parcelize
data class ContactsModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String? = null,
    val surname: String? = null,
    val profilePath: Int? = null,
) : Parcelable
