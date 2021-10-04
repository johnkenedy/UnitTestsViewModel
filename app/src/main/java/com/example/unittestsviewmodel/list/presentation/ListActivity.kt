package com.example.unittestsviewmodel.list.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.unittestsviewmodel.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var viewModel: ListViewModel
    private val factory = ListViewModel.Factory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)

        viewModel = ViewModelProviders.of(this, factory).get(ListViewModel::class.java)
        setupObservers()
        setupListAdapter()
        viewModel.fetchData()

        setContentView(binding.root)
    }

    private fun setupListAdapter() {
        binding.rvListName.adapter = ListAdapter()
    }

    private fun setupObservers() {
        viewModel.onDataLoaded.observe(this, Observer {
            (binding.rvListName.adapter as ListAdapter).setData(it)
        })
    }
}
