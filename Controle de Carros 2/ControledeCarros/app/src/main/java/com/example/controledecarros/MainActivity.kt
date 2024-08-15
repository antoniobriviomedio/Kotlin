package com.example.controledecarros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            try {
                val marca = binding.editMarca.text.toString()
                val modelo = binding.editModelo.text.toString()
                val ano = binding.editAno.text.toString().toInt()

                // Instanciando o objeto Carro
                carro = Carro(marca, modelo, ano, 0)
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                binding.textDetalhes.text = e.message
            }
        }

        binding.buttonQuilometragem.setOnClickListener {
            try {
                val novaQuilometragem = binding.editQuilometragem.text.toString().toInt()
                carro.quilometragem = novaQuilometragem
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                binding.textDetalhes.text = e.message
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
