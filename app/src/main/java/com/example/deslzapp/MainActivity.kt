package com.example.deslzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.deslzapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }}

//        binding.BottomNavigationView.setOnItemSelectedListener{ item ->
//        when (item.itemId){
//            R.id.opBotones -> {
//                Navigation.findNavController(binding.fragmentContainerView)
//                    .navigate(R.id.firstFragment)
//                true
//            }
//            R.id.opSelectorBar -> {
//                findNavController(R.id.fragmentContainerView)
//                    .navigate(R.id.secondFragment)
//                true
//            }
//            R.id.opSeekBar -> {
//                binding.fragmentContainerView.findNavController()
//                    .navigate(R.id.thirdFragment)
//                true
//            }
//            else -> false
//        }
//
//    }

