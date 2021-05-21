package com.example.moviedb.core.interfaces

import android.view.View
import com.example.moviedb.core.domain.model.DataModels

interface UserInterface {
    fun onUserClicked(view: View, dataModels: DataModels)
}