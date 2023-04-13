package com.example.whatsappui.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappui.util.Util.dpToPx

@BindingAdapter("app:equalSpacing")
fun RecyclerView.itemDecoration(dp: Int) {
    var orientation = 0
    if (layoutManager is GridLayoutManager) {
        orientation = -1
    } else if (layoutManager is LinearLayoutManager) {
        orientation = (layoutManager as LinearLayoutManager).orientation
    }
    if (0 == itemDecorationCount) {
        addItemDecoration(EqualSpacingItemDecoration(dpToPx(dp), orientation, true))
    }
}
