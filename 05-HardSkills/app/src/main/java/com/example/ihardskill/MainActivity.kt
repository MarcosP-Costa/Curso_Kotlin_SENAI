package com.example.ihardskill

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton;
import android.widget.*
import com.example.ihardskill.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    lateinit var botao: Button
    lateinit var grupo: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rolarBotaoDetalhe: Button = findViewById(R.id.botaoDetalhes)
        val rolarBotaoDano: Button = findViewById(R.id.botaoDano)
        val rolarBotaoDanoCausado: Button = findViewById(R.id.botaoRolar)
        val resultTextView: TextView = findViewById(R.id.textView)
        val comentTextView: TextView = findViewById(R.id.comentarioDano)
        rolarBotaoDetalhe.setOnClickListener { mostrarDetalhes() }
        rolarBotaoDano.setOnClickListener { mostrarDano() }
        rolarBotaoDanoCausado.setOnClickListener { rolarDano1() }


        grupo = findViewById(R.id.armas)

        grupo.setOnCheckedChangeListener { group, checkedId ->
            //   resultTextView.text = ""

            if (checkedId == R.id.radioMachado)
                rolarAtaque(12, "Machado")

            if (checkedId == R.id.radioEspada)
            // resultTextView.text = "Sua Espada deu 10 de dano!"
                rolarAtaque(10, "Espada")
            if (checkedId == R.id.radioArco)
            //  resultTextView.text = "Seu Arco deu 8 de dano!"
                rolarAtaque(8, "Arco e Flecha")

        }


    }

    private fun rolarDano1() {
        if (grupo.checkedRadioButtonId != null) {
            var radioSelecionado: RadioButton
            radioSelecionado = findViewById(grupo.checkedRadioButtonId)
            Toast.makeText(
                applicationContext,
                "Arma Selecionada: " + radioSelecionado.text,
                Toast.LENGTH_LONG
            ).show()
            val comentTextView: TextView = findViewById(R.id.comentarioDano)
            comentTextView.text = ""


        } else {
            Toast.makeText(applicationContext, "Nenhuma opção selecionada ", Toast.LENGTH_LONG)
                .show()
        }
    }


    // deu certo aqui em baixo kk
    private fun mostrarDetalhes() {

        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text =
            "Machado da mais dano que as outras armas, porém precisa ser usada com as duas mãos  \n\nArco e Flecha tem a vantagem da distancia, mas da menos dano que as outras armas \n\nEspada é um meio termo, da menos dano que um machado, porém pode ser usada com somente uma mão"
        val comentTextView: TextView = findViewById(R.id.comentarioDano)
        comentTextView.text = ""
    }

    private fun mostrarDano() {
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text =
            "Machado da 1d12 de dano\nEspada da 1d10 de dano\nArco e Flecha dao 1d8 de dano"
        val comentTextView: TextView = findViewById(R.id.comentarioDano)
        comentTextView.text = ""
    }


    //função de rolar o ataque
    private fun rolarAtaque(dadoDeDano: Int, tipoDeArma: String) {
        val resultTextView: TextView = findViewById(R.id.textView)
        val comentTextView: TextView = findViewById(R.id.comentarioDano)
        val danoRolado = Ataque(dadoDeDano)
        val armaUsada = tipoDeArma
        val danoCausado = danoRolado.rolarDano()
        when (danoCausado) {
            1, 2, 3 -> comentTextView.text = "Dano Mixuruca hein, da pra melhorar"
            4, 5, 6 -> comentTextView.text = "Dano Mediano, mas ta ok"
            7, 8, 9 -> comentTextView.text = "Rapaz, vamo com calma! isso é a vida de um goblin"
            10, 11, 12 -> comentTextView.text = "CRITICAL HIT!"
        }
        resultTextView.text = "O seu ataque de " + armaUsada + " deu " + danoCausado + " de dano"

    }

}

class Ataque(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun rolarDano(): Int {
        return (1..numSides).random()
    }
}