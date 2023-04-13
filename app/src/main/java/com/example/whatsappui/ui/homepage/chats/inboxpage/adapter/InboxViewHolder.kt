package com.example.whatsappui.ui.homepage.chats.inboxpage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.data.model.messagespage.MessagesModel
import com.example.whatsappui.databinding.ItemRowInboxBinding

class InboxViewHolder(private val binding: ItemRowInboxBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(
        messagesModel: MessagesModel,
    ) {
        binding.model = messagesModel
    }

    companion object {
        fun from(parent: ViewGroup) =
            InboxViewHolder(
                ItemRowInboxBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false,
                ),
            )
    }
}
