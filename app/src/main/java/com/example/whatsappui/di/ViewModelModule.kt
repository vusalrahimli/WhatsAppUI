package com.example.whatsappui.di

import com.example.whatsappui.ui.homepage.chats.ChatsVM
import com.example.whatsappui.ui.homepage.chats.inboxpage.InboxVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ChatsVM(get(), get())
    }
    viewModel {
        InboxVM(get(), get())
    }
}
