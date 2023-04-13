package com.example.whatsappui.ui.homepage.chats.adapters.chatsadapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.whatsappui.data.model.homepage.ContactsModel

class ChatsAdapter : ListAdapter<ContactsModel, ChatsViewHolder>(DifferCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatsViewHolder =
        ChatsViewHolder.from(parent)

    override fun onBindViewHolder(holder: ChatsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private object DifferCallBack : DiffUtil.ItemCallback<ContactsModel>() {
        override fun areItemsTheSame(oldItem: ContactsModel, newItem: ContactsModel) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ContactsModel, newItem: ContactsModel) =
            oldItem == newItem
    }
}
