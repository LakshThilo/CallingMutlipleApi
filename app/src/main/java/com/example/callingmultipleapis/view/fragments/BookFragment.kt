package com.example.callingmultipleapis.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.callingmultipleapis.databinding.RecyclerViewListLayoutBinding
import com.example.callingmultipleapis.model.dataclasses.book.BookResponse
import com.example.callingmultipleapis.model.remote.network.HttpRequests
import com.example.callingmultipleapis.model.service.ServiceType
import com.example.callingmultipleapis.view.adapters.BookRecyclerAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers


private const val TAG = "BookFragment"

class BookFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getBookData()
    }

    private fun getBookData() {

        HttpRequests.getService(
            ServiceType.Book
        ).getBooks("q",
            printType = "books")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.let {
                    displayData(it)
                    // Toast.makeText(activity, "${it.items[0].volumeInfo.title}", Toast.LENGTH_SHORT).show()
                }
            },{
                Log.e(TAG, "getBooksData", it)
            })
    }

    private fun displayData(bookResponse: BookResponse) {
        Toast.makeText(activity, bookResponse.items[0].volumeInfo.title, Toast.LENGTH_SHORT).show()
    }

    private val adapter : BookRecyclerAdapter by lazy {
        createAdapter()
    }

    private lateinit var binding : RecyclerViewListLayoutBinding

    private fun createAdapter() : BookRecyclerAdapter{
        return BookRecyclerAdapter(
            clickDetails = :: openDetails,
            dataSet = emptyList()
        )
    }

    private fun openDetails(bookResponse: BookResponse) {

        Log.d(TAG, "openDetails: ")
        activity?.showDetails(bookResponse)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)


        return binding.root
    }

}


// EXTENSION FUNCTION
fun FragmentActivity.showDetails(bookResponse: BookResponse){


}