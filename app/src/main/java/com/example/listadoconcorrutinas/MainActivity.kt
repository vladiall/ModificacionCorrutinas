package com.example.listadoconcorrutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val repository : PersonRepository = PersonRepositoryImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewPerson  = findViewById<TextView>(R.id.textView_person)
        textViewPerson.text = ""
        val buttonGetListPerson = findViewById<Button>(R.id.button_getList)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        buttonGetListPerson.setOnClickListener {
            textViewPerson.text = ""
            progressBar.visibility = View.VISIBLE
            lifecycleScope.launch {
                val listPerson = withContext(Dispatchers.IO) {
                    Thread.sleep(5000)
                    repository.getPersons()
                }
                for (persona in listPerson) {
                    textViewPerson.append("Nombre: ${persona.name} ${persona.surname} | Edad: ${persona.edad} \n")
                }
                progressBar.visibility = View.INVISIBLE
            }
        }
    }
}