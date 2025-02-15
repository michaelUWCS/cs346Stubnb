package com.example.myapplication.models

data class Inventory(
    val name: String,
    val userId: String,
    val description: String,
    val imageLinks: List<String>,
    val price: Double,
    val subject: String,
    val category: String,
    val condition: String,
    val timeStamp: String
){
    constructor() : this("", "", "", mutableListOf(), 0.0, "", "", "", "")

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Inventory

        if (name != other.name) return false
        if (userId != other.userId) return false
        if (description != other.description) return false
        if (imageLinks != other.imageLinks) return false

        return true
    }
}

//data class Person(val name: String, var age: Int)
