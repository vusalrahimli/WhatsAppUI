package com.example.whatsappui.ui.homepage.chats.inboxpage

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.whatsappui.data.model.homepage.ContactsModel
import com.example.whatsappui.data.model.messagespage.MessagesModel
import com.example.whatsappui.databinding.FragmentInboxBinding
import com.example.whatsappui.ui.homepage.chats.inboxpage.adapter.InboxAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*

class InboxFragment : Fragment() {

    private val binding by lazy {
        FragmentInboxBinding.inflate(layoutInflater)
    }

    private val args by navArgs<InboxFragmentArgs>()

    private var contactModel: ContactsModel? = null

    private val viewModel: InboxVM by viewModel()

    private var dateAndTime: Date? = null

    private var timeFormat: SimpleDateFormat? = null

    private var time: String? = null

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
        contactModel = args.contactsModel
        binding.inboxToolbar.title = contactModel?.name
        viewModel.getMessagesByPersonId(contactModel!!.id).observe(viewLifecycleOwner) {
            adapterInbox.submitList(it)
        }
    }

    private fun setClicks() {
        binding.editTextTypeMsg.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                binding.sendButton.setOnClickListener {
                    if (!s.toString().isNullOrEmpty()) {
                        viewLifecycleOwner.lifecycleScope.launch {
                            viewModel.insertMessageToInbox(createMessagesModel(s.toString()))
                            binding.editTextTypeMsg.text?.clear()
                        }
                    }
                }
            }
        })

        binding.inboxToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    private val adapterInbox by lazy {
        InboxAdapter().also {
            binding.rvInbox.adapter = it
        }
    }

    private fun createMessagesModel(message: String): MessagesModel {
        dateAndTime = Calendar.getInstance().time
        timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
        time = dateAndTime?.let { timeFormat!!.format(it) }

        return MessagesModel(
            0,
            contactModel?.id,
            message,
            time,
        )
    }
}
