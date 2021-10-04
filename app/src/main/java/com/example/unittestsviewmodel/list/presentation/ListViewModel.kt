package com.example.unittestsviewmodel.list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.unittestsviewmodel.list.data.Repository
import com.example.unittestsviewmodel.list.data.RepositoryImpl

class ListViewModel(private val repository: Repository): ViewModel() {

    val onDataLoaded = MutableLiveData<List<String>>()

    fun fetchData() {
        val namesList = repository.getData()
        onDataLoaded.value = namesList
    }

    @Suppress("UNCHECKED_CAST")
    class Factory: ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ListViewModel(RepositoryImpl()) as T
        }
    }
}