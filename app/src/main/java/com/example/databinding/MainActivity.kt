package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mycontact: Contact = Contact ("See","1234")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Binding the UI to the program variable
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.contact = mycontact
        binding.buttonDone.setOnClickListener {
            changeContact(it)
        }

    }
    private fun changeContact(it:View?){
        binding.apply{
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhone.text.toString()
            this.invalidateAll() //refresh the UI
        }
        //binding.contact?.name = editTextName.text.toString()
    }
}





