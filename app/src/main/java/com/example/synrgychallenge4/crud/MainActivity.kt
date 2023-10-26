package com.example.synrgychallenge4.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.synrgychallenge4.R
import com.example.synrgychallenge4.databinding.ActivityMain2Binding
import com.example.synrgychallenge4.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMain2Binding
    lateinit var viewModel: ViewModel

    private var mAdapter : UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        binding.buttonAdd.setOnClickListener{
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setAdapter(list:List<User>){
        mAdapter?.setData(list)
    }

    override fun onResume(){
        super.onResume()
        lifecycleScope.launch {
            val userList = AppDatabase(this@MainActivity).getUserDao().getAllUser()

            mAdapter = UserAdapter()
            binding.recyclerviewUser.apply{
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mAdapter
                setAdapter(userList)

                mAdapter?.setOnActionEditListener {
                    val intent = Intent(this@MainActivity, AddActivity::class.java)
                    intent.putExtra("Data", it)
                    startActivity(intent)
                }

                mAdapter?.setOnActionDeleteListener {
                    val builder = AlertDialog.Builder(this@MainActivity)
                    builder.setMessage("Delete user ini?")
                    builder.setPositiveButton("YES"){ p0, p1 ->
                        lifecycleScope.launch{
                            AppDatabase(this@MainActivity).getUserDao().deleteUser(it)
                    }
                        p0.dismiss()
                    }
                    builder.setNegativeButton("NO"){
                            p0, p1 -> p0.dismiss()
                    }
                    val dialog = builder.create()
                    dialog.show()
                }
//                    UserAdapter().apply {
//                    setData(userList)

            }
//            Log.e("aaaaaa", "onResume: ${userList.size}")
        }
    }
}