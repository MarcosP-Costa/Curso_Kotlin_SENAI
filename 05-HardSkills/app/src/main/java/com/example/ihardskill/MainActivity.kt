package com.example.ihardskill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import com.example.ihardskill.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding:ActivityMainBinding
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rolarBotaoDetalhe: Button = findViewById(R.id.botaoDetalhes)
        val rolarBotaoDano: Button = findViewById(R.id.botaoDano)
        val rolarBotaoDanoCausado: Button = findViewById(R.id.botaoRolar)
        rolarBotaoDetalhe.setOnClickListener { mostrarDetalhes() }
        rolarBotaoDano.setOnClickListener { mostrarDano()}
        rolarBotaoDanoCausado.setOnClickListener{ rolarDano1()}




    }

    fun rolarDano1(view : View): String {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioMachado ->
                    if (checked) {
                        //checked vai retornar um boleano
                        val resultTextView: TextView = findViewById(R.id.textView)
                        resultTextView.text = "Teste1"
                    }
                R.id.radioEspada ->
                    if (checked) {
                        val resultTextView: TextView = findViewById(R.id.textView)
                        resultTextView.text = "Teste2"
                    }

            }
        }
        return "?"
    }














    // deu certo aqui em baixo kk
    private fun mostrarDetalhes() {

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = "Machado > Espada > Arco"
    }

    private fun mostrarDano(){
        val resultTextView2: TextView = findViewById(R.id.textView)
        resultTextView2.text = "Machado da 12, Espada da 10, Arco da 8"
    }

}