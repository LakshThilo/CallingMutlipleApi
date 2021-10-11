package com.example.callingmultipleapis.view.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.callingmultipleapis.databinding.SingleBookItemLayoutBinding
import com.example.callingmultipleapis.model.dataclasses.book.BookResponse
import com.example.callingmultipleapis.model.dataclasses.book.VolumeInfo

class BookViewHolder(private val binding: SingleBookItemLayoutBinding,
private val click: (BookResponse) -> Unit): RecyclerView.ViewHolder(binding.root) {

    fun onBinding(bookItem: BookResponse){

    }
}