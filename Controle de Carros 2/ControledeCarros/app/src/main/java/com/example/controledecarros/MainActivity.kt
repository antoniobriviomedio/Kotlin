package com.example.controledecarros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.controledecarros.databinding.ActivityMainBinding
import com.example.controledecarros.model.Carro

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var carro: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurando o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCriar.setOnClickListener {
            val marca = binding.editMarca.text.toString()
            val modelo = binding.editModelo.text.toString()
            val anoString = binding.editAno.text.toString()

            try {
                val ano = anoString.toInt()
                // Instanciando o objeto Carro com quilometragem inicial 0
                carro = Carro(marca, modelo, ano, 0)
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Ano inválido! Por favor, insira um número válido.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonQuilometragem.setOnClickListener {
            val quilometragemString = binding.editQuilometragem.text.toString()

            try {
                val novaQuilometragem = quilometragemString.toInt()
                carro.quilometragem = novaQuilometragem
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Quilometragem inválida! Por favor, insira um número válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun mostrarDetalhes() {
        val detalhes = """
            Marca: ${carro.getMarca()}
            Modelo: ${carro.getModelo()}
            Ano: ${carro.getAno()}
            Quilometragem: ${carro.quilometragem}
        """.trimIndent()

        binding.textDetalhes.text = detalhes
    }
}
