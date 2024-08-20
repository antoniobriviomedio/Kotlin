package com.example.controledecarros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import com.example.controledecarros.databinding.ActivityMainBinding
import com.example.controledecarros.model.Carro
import com.example.controledecarros.model.Taxi


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var veiculo: Carro

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

                // Verificar a seleção do RadioGroup
                val selectedRadioButtonId = binding.radioGroupTipoVeiculo.checkedRadioButtonId
                val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val tipoVeiculo = radioButton.text.toString()

                // Instanciar o objeto com base na seleção do usuário
                veiculo = if (tipoVeiculo == "Táxi") {
                    Taxi(marca, modelo, ano, 0)
                } else {
                    Carro(marca, modelo, ano, 0)
                }
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Por favor, insira valores numéricos válidos para o ano e quilometragem.", Toast.LENGTH_LONG).show()
            } catch (e: IllegalArgumentException) {
                binding.textDetalhes.text = e.message
            }
        }

        binding.buttonQuilometragem.setOnClickListener {
            try {
                val novaQuilometragem = binding.editQuilometragem.text.toString().toInt()
                veiculo.quilometragem = novaQuilometragem

                // Verificação da quilometragem e exibição do Toast
                if (veiculo is Taxi && veiculo.quilometragem >= 200_000) {
                    Toast.makeText(this, "Atenção: O veículo atingiu ou ultrapassou 200.000 km!", Toast.LENGTH_LONG).show()
                }
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                binding.textDetalhes.text = e.message
            }
        }
    }
    private fun mostrarDetalhes() {
        val detalhes = """
            Tipo: ${if (veiculo is Taxi) "Táxi" else "Carro"}
            Marca: ${veiculo.getMarca()}
            Modelo: ${veiculo.getModelo()}
            Ano: ${veiculo.getAno()}
            Quilometragem: ${veiculo.quilometragem}
        """.trimIndent()

        binding.textDetalhes.text = detalhes
    }
}
