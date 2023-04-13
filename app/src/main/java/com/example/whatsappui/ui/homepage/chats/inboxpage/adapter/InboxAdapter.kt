package com.example.whatsappui.ui.homepage.chats.inboxpage.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappui.data.model.messagespage.MessagesModel

class InboxAdapter : ListAdapter<MessagesModel, InboxViewHolder>(DifferCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder =
        InboxViewHolder.from(parent)

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object DifferCallBack : DiffUtil.ItemCallback<MessagesModel>() {
        override fun areItemsTheSame(oldItem: MessagesModel, newItem: MessagesModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MessagesModel, newItem: MessagesModel) =
            oldItem == newItem
    }
}
