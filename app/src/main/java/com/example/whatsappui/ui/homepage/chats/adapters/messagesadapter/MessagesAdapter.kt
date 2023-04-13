package com.example.whatsappui.ui.homepage.chats.adapters.messagesadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappui.data.model.homepage.ContactsModel

class MessagesAdapter : ListAdapter<ContactsModel, MessagesViewHolder>(DifferCallBack) {

    var setOnItemClick: ((ContactsModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder =
        MessagesViewHolder.from(parent)

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(
            getItem(position),

            onItemClick = setOnItemClick,
        )
    }

    private object DifferCallBack : DiffUtil.ItemCallback<ContactsModel>() {
        override fun areItemsTheSame(oldItem: ContactsModel, newItem: ContactsModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ContactsModel, newItem: ContactsModel) =
            oldItem == newItem
    }
}
