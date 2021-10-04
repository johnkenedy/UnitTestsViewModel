package com.example.unittestsviewmodel.list.data

interface Repository {
    fun getData(): List<String>
}

class RepositoryImpl: Repository {

    override fun getData(): List<String> {
        return listOf(
            "John Kenedy",
            "Leonardo",
            "Daniela",
            "Alessandra",
            "Victor",
            "Mateus"
        )
    }
}