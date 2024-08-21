package com.example.controledecarrosexercicio

import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.controledecarrosexercicio.databinding.ActivityMainBinding
import com.example.controledecarrosexercicio.model.Caminhao
import com.example.controledecarrosexercicio.model.Motocicleta
import com.example.controledecarrosexercicio.model.Veiculo


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var veiculo: Veiculo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurando o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar o comportamento dos RadioButtons
        binding.radioGroupTipoVeiculo.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioMoto -> {
                    binding.editCilindradas.isEnabled = true
                    binding.editCapacidadeCarga.isEnabled = false
                    binding.editCapacidadeCarga.text.clear() // Limpar o campo quando desabilitado
                }
                R.id.radioCaminhao -> {
                    binding.editCilindradas.isEnabled = false
                    binding.editCapacidadeCarga.isEnabled = true
                    binding.editCilindradas.text.clear() // Limpar o campo quando desabilitado
                }
            }
        }

        // Inicialmente, desabilitar o campo de Capacidade de Carga
        binding.editCapacidadeCarga.isEnabled = false

        binding.buttonCriar.setOnClickListener {
            try {
                val marca = binding.editMarca.text.toString()
                val modelo = binding.editModelo.text.toString()
                val ano = binding.editAno.text.toString().toIntOrNull()
                val quilometragem = binding.editQuilometragem.text.toString().toIntOrNull()

                if (ano == null || quilometragem == null) {
                    showToast("Por favor, insira valores numéricos válidos.")
                    return@setOnClickListener
                }

                // Verificar a seleção do RadioGroup
                val selectedRadioButtonId = binding.radioGroupTipoVeiculo.checkedRadioButtonId
                val radioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val tipoVeiculo = radioButton.text.toString()

                // Instanciar o objeto com base na seleção do usuário
                veiculo = if (tipoVeiculo == "Moto") {
                    val cilindradas = binding.editCilindradas.text.toString().toIntOrNull()
                    if (cilindradas == null) {
                        showToast("Por favor, insira um valor numérico válido para cilindradas.")
                        return@setOnClickListener
                    }
                    Motocicleta(marca, modelo, ano, quilometragem, cilindradas)
                } else {
                    val capacidadeCarga = binding.editCapacidadeCarga.text.toString().toIntOrNull()
                    if (capacidadeCarga == null) {
                        showToast("Por favor, insira um valor numérico válido para a capacidade de carga.")
                        return@setOnClickListener
                    }
                    Caminhao(marca, modelo, ano, quilometragem, capacidadeCarga)
                }
                mostrarDetalhes()

            } catch (e: NumberFormatException) {
                showToast("Por favor, insira valores numéricos válidos.")
            } catch (e: IllegalArgumentException) {
                showToast(e.message)
            }
        }

        binding.buttonAtualizarQuilometragem.setOnClickListener {
            try {
                val novaQuilometragem = binding.editQuilometragem.text.toString().toIntOrNull()
                if (novaQuilometragem == null) {
                    showToast("Por favor, insira um valor numérico válido para a quilometragem.")
                    return@setOnClickListener
                }
                veiculo.quilometragem = novaQuilometragem
                mostrarDetalhes()

            } catch (e: NumberFormatException) {
                showToast("Por favor, insira um valor numérico válido para a quilometragem.")
            } catch (e: IllegalArgumentException) {
                showToast(e.message)
            }
        }
    }

    private fun mostrarDetalhes() {
        val detalhes = when (veiculo) {
            is Motocicleta -> """
                Tipo: Moto
                Marca: ${veiculo.marca}
                Modelo: ${veiculo.modelo}
                Ano: ${veiculo.ano}
                Quilometragem: ${veiculo.quilometragem}
                Cilindradas: ${(veiculo as Motocicleta).cilindradas}
            """.trimIndent()
            is Caminhao -> """
                Tipo: Caminhão
                Marca: ${veiculo.marca}
                Modelo: ${veiculo.modelo}
                Ano: ${veiculo.ano}
                Quilometragem: ${veiculo.quilometragem}
                Capacidade de Carga: ${(veiculo as Caminhao).capacidadeCarga} kg
            """.trimIndent()
            else -> ""
        }

        binding.textDetalhes.text = detalhes
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}

