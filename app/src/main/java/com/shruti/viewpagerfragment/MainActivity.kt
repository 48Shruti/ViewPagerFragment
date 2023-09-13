package com.shruti.viewpagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.shruti.viewpagerfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var item = ArrayList<Fragment>()
    var titles = arrayListOf<String>("First","Second","Third")
    lateinit var adapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        item.add(FragmentFirst())
        item.add(FragmentSecond())
        item.add(FragmentThird())
        adapter = FragmentAdapter(this,item)
        binding.viewpager.adapter = adapter
        TabLayoutMediator(binding.tab,binding.viewpager){
            tab ,position -> tab.text = titles[position]
        }
            .attach()

    }
}