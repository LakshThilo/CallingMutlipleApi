package com.example.callingmultipleapis.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.callingmultipleapis.databinding.SingleBookItemLayoutBinding
import com.example.callingmultipleapis.model.dataclasses.book.BookResponse
import com.example.callingmultipleapis.model.dataclasses.book.VolumeInfo
import com.example.callingmultipleapis.view.viewholders.BookViewHolder

class BookRecyclerAdapter(var dataSet: List<BookResponse>, private val clickDetails: (BookResponse) -> Unit) :
    RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        return BookViewHolder(
            SingleBookItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            clickDetails
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBinding(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}