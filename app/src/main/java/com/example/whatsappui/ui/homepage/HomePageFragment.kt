package com.example.whatsappui.ui.homepage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.whatsappui.databinding.FragmentHomePageBinding
import com.example.whatsappui.ui.homepage.calls.CallsFragment
import com.example.whatsappui.ui.homepage.chats.ChatsFragment
import com.example.whatsappui.ui.homepage.contacts.ContactsFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomePageFragment : Fragment() {

    private val binding by lazy {
        FragmentHomePageBinding.inflate(layoutInflater)
    }

    private val fragments = ArrayList<Fragment>()

    private val adapterVP by lazy {
        ViewPagerAdapter(this@HomePageFragment, fragments).also {
            binding.viewPager.adapter = it
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadTabLayout()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    private fun loadTabLayout() {
        fragments.add(CallsFragment())
        fragments.add(ChatsFragment())
        fragments.add(ContactsFragment())

        adapterVP

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Calls"
                1 -> "Chats"
                2 -> "Contacts"
                else -> ""
            }
        }.attach()
    }
}
