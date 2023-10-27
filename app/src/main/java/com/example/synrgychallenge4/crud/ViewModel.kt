package com.example.synrgychallenge4.crud

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(
    private val userDao: UserDao
) : ViewModel() {
    val users: LiveData<List<User>> = userDao.getAllUser()

    fun addUser(firstName: String, lastName: String){
        viewModelScope.launch{
            val user = User(firstName = firstName, lastName = lastName)
            userDao.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch{
            userDao.updateUser(user)
        }
    }


}