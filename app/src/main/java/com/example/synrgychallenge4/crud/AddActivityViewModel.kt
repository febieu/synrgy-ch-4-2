package com.example.synrgychallenge4.crud

import androidx.lifecycle.ViewModel

class AddActivityViewModel : ViewModel() {
    private var user: User? = null

    fun setUser(newUser: User?){
        user = newUser
    }

    fun getUser(): User?{
        return user
    }
}