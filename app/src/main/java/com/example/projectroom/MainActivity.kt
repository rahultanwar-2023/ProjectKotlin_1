package com.example.projectroom

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectroom.adapter.MyInfoAdapter
import com.example.projectroom.database.MyInfoDatabase
import com.example.projectroom.model.MyInfo
import com.example.projectroom.repository.MyInfoRepository
import com.example.projectroom.viewmodel.MyInfoViewModel
import com.example.projectroom.viewmodel.MyInfoViewModelFactory
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), MyInfoAdapter.MyInfoClickInterface {

    lateinit var itemsRV: RecyclerView
    lateinit var list: List<MyInfo>
    lateinit var myInfoAdapter: MyInfoAdapter
    lateinit var myInfoViewModel: MyInfoViewModel
    lateinit var add: Button
    lateinit var show: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRV = findViewById(R.id.myInfoRv)
        add = findViewById(R.id.btn_add)
        show = findViewById(R.id.btn_show)
        list = ArrayList<MyInfo>()
        myInfoAdapter = MyInfoAdapter(list, this)
        itemsRV.layoutManager = LinearLayoutManager(this)
        itemsRV.adapter = myInfoAdapter
        val groceryRepository = MyInfoRepository(MyInfoDatabase(this))
        val factory = MyInfoViewModelFactory(groceryRepository)
        myInfoViewModel = ViewModelProvider(this, factory)[MyInfoViewModel::class.java]


        add.setOnClickListener {
            addMyInfo()
        }

        show.setOnClickListener {
            myInfoViewModel.getAllMyInfo().observe(this, Observer {
                myInfoAdapter.list = it
                myInfoAdapter.notifyDataSetChanged()
            })
        }
    }

    private fun addMyInfo() {
        val nameEdit = findViewById<TextInputEditText>(R.id.edit_name)
        val motherEdit = findViewById<TextInputEditText>(R.id.edit_mother)
        val ageEdit = findViewById<TextInputEditText>(R.id.edit_age)

        val name = nameEdit.text.toString()
        val mother = motherEdit.text.toString()
        val age = ageEdit.text.toString()
        if (name.isEmpty() && mother.isEmpty() && age.isEmpty()) {
            Toast.makeText(applicationContext, "Please enter all the data..", Toast.LENGTH_SHORT)
                .show()
        } else {
            val items = MyInfo(0, name, mother, age.toInt())
            myInfoViewModel.insert(items)
            Toast.makeText(applicationContext, "Item Inserted..", Toast.LENGTH_SHORT).show()
            myInfoAdapter.notifyDataSetChanged()
        }

    }

    override fun onItemClick(myInfo: MyInfo) {
        myInfoViewModel.delete(myInfo)
        myInfoAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext,"Item Deleted..",Toast.LENGTH_SHORT).show()
    }
}