package com.example.listadoconcorrutinas

interface PersonRepository {

    fun getPersons() : ArrayList<Person>
}