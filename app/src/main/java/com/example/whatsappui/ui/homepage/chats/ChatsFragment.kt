package com.example.whatsappui.ui.homepage.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.whatsappui.R
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.databinding.FragmentChatsBinding
import com.example.whatsappui.ui.homepage.HomePageFragmentDirections
import com.example.whatsappui.ui.homepage.chats.adapters.chatsadapter.ChatsAdapter
import com.example.whatsappui.ui.homepage.chats.adapters.messagesadapter.MessagesAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatsFragment : Fragment() {

    private val binding by lazy {
        FragmentChatsBinding.inflate(layoutInflater)
    }

    private val viewModel: ChatsVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToObservables()
        setClicks()
    }

    private fun subscribeToObservables() {
        viewLifecycleOwner.lifecycleScope.launch {
            delay(300)
            val contact1 = ContactsModel(1, "Pranav", "Ray", R.drawable.pranav)
            val contact2 = ContactsModel(2, "Ayesha", "Tanvar", R.drawable.ayesha)
            val contact3 = ContactsModel(3, "Roshni", null, R.drawable.roshni)
            val contact4 = ContactsModel(4, "Dad", null, R.drawable.dad)

            viewModel.insertContact(contact1)
            viewModel.insertContact(contact2)
            viewModel.insertContact(contact3)
            viewModel.insertContact(contact4)

            viewModel.fetchContacts().observe(viewLifecycleOwner) {
                adapterChats.submitList(it)
                adapterMessages.submitList(it)
            }
        }
    }

    private fun setClicks() {
        adapterMessages.setOnItemClick = {
            findNavController().navigate(
                HomePageFragmentDirections.actionHomePageFragmentToInboxFragment(it),
            )
        }
    }

    private val adapterChats by lazy {
        ChatsAdapter().also {
            binding.rvChats.adapter = it
        }
    }

    private val adapterMessages by lazy {
        MessagesAdapter().also {
            binding.rvMessages.adapter = it
        }
    }
}
