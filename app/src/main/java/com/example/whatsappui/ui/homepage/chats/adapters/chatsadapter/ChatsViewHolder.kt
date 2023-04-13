package com.example.whatsappui.ui.homepage.chats.adapters.chatsadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.databinding.ItemRowChatsBinding

class ChatsViewHolder(private val binding: ItemRowChatsBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        contactsModel: ContactsModel,
    ) {
        binding.model = contactsModel
    }

    companion object {
        fun from(parent: ViewGroup) =
            ChatsViewHolder(
                ItemRowChatsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )
    }
}
