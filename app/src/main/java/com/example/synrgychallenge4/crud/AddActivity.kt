package com.example.synrgychallenge4.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.synrgychallenge4.R
import com.example.synrgychallenge4.databinding.ActivityAddBinding
import kotlinx.coroutines.launch

class AddActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddBinding
    private lateinit var ViewModel: ViewModel
    private lateinit var addActivityViewModel: AddActivityViewModel
    private var user : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        addActivityViewModel = ViewModelProvider(this).get(AddActivityViewModel::class.java)

        var user = addActivityViewModel.getUser()
        addActivityViewModel.setUser(user)

        user = intent.getSerializableExtra("Data") as User?

        if(user == null){
            binding.buttonAddOrUpdateUser.text = "Add user"
        } else{
            binding.buttonAddOrUpdateUser.text = "Update"
            binding.edittextFirstName.setText(user?.firstName.toString())
            binding.edittextLastName.setText(user?.lastName.toString())
        }

        binding.buttonAddOrUpdateUser.setOnClickListener{
            addUser()
        }
    }

    private fun addUser(){
        val firstName = binding.edittextFirstName.text.toString()
        val lastName = binding.edittextLastName.text.toString()

        if (user == null) {
            ViewModel.addUser(firstName, lastName)
        } else {
            val u = User(firstName, lastName)
            u.id = user?.id ?: 0
            ViewModel.updateUser(u)
        }

        finish()
    }
}