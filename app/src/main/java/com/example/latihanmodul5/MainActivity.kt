package com.example.latihanmodul5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list = ArrayList<Handphone>()
    private lateinit var rvHandphone : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rvHandphone = binding.rvHandphone
        rvHandphone.setHasFixedSize(true)
        list.addAll(getListHandphone())
        showRecyclerList()
    }
    private fun getListHandphone(): ArrayList<Handphone> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription =
            resources.getStringArray(R.array.data_description)
        val dataPhoto =
            resources.obtainTypedArray(R.array.data_photo)
        val listHandphone = ArrayList<Handphone>()
        for (i in dataName.indices) {
            val handphone = Handphone(dataName[i],
                dataDescription[i], dataPhoto.getResourceId(i, -1))
            listHandphone.add(handphone)
        }
        return listHandphone
    }
    private fun showRecyclerList() {
        rvHandphone.layoutManager = LinearLayoutManager(this)
        val listHandphoneAdapter = ListHandphoneAdapter(list)
        rvHandphone.adapter = listHandphoneAdapter
    }
}
