package com.example.whatsappui.ui.homepage.chats.adapters.messagesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.databinding.ItemRowMessagesBinding

class MessagesViewHolder(private val binding: ItemRowMessagesBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        contactsModel: ContactsModel,
        onItemClick: ((ContactsModel) -> Unit)?,
    ) {
        binding.model = contactsModel
        binding.root.setOnClickListener {
            onItemClick?.invoke(contactsModel)
        }
    }

    companion object {
        fun from(parent: ViewGroup) =
            MessagesViewHolder(
                ItemRowMessagesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )
    }
}
