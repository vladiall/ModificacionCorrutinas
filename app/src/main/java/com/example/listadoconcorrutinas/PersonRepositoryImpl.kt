package com.example.listadoconcorrutinas

class PersonRepositoryImpl : PersonRepository {

    private val listPerson = ArrayList<Person>()

    init {
        listPerson.add(Person("Martin Alonso", "Pinzon", 53))
        listPerson.add(Person("Juan Sebastian", "Elcano", 40))
        listPerson.add(Person("Americo", "Vespucio", 58))
    }

    override fun getPersons(): ArrayList<Person> {
        return listPerson
    }


}