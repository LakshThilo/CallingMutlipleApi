package com.example.callingmultipleapis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.callingmultipleapis.databinding.ActivityMainBinding
import com.example.callingmultipleapis.model.service.ServiceType
import com.example.callingmultipleapis.view.fragments.BookFragment
import com.example.callingmultipleapis.view.fragments.ContactFragment
import com.example.callingmultipleapis.view.fragments.MovieFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.next_fragment).setOnClickListener(this::nextFragment)
        moveNextFragment(ServiceType.Book)


    }

    private fun nextFragment(view: View?) {
        counter ++
        when(counter) {

            0 -> moveNextFragment(ServiceType.Book)
            1 -> moveNextFragment(ServiceType.Contact())
            else -> {
                counter = -1
                moveNextFragment(ServiceType.Movie())
            }
        }

    }

    private fun moveNextFragment(fragmentType: ServiceType) {

        when(fragmentType) {
            is ServiceType.Book -> {inflateBookFragment()}
            is ServiceType.Contact -> {inflateContactFragment()}
            is ServiceType.Movie -> {inflateMovieFragment()}
        }
    }

    private fun inflateMovieFragment() {
      supportFragmentManager.beginTransaction()
          .replace(R.id.fragmentContainer, MovieFragment())
          .commit()
    }

    private fun inflateContactFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ContactFragment())
            .commit()
    }

    private fun inflateBookFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, BookFragment())
            .commit()
    }
}



/*
*   1. Debug and Analyze the Endpoints              - Urls -books/contacts/movies
*   2. Create data classes                          - model/dataClasses
*   3. Add dependencies                             - build.gradle /module
*   4. Create the Endpoints (Retrofit interface)    - interfaces/Api
*   5. Configure the Retrofit Client (builder)      - network/ Http Requests
*   6. Consume the request (Execute / Enqueue)      -
*
* */