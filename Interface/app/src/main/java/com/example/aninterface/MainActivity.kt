package com.example.aninterface

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aninterface.databinding.ActivityMainBinding
import com.example.aninterface.models.Carro
import com.example.aninterface.models.Motocicleta
import com.example.aninterface.interfaces.Veiculo

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val motocicleta: Veiculo = Motocicleta("Yamaha", "MT-07", 689)
    private val carro: Veiculo = Carro("Toyota", "Corolla", 4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegistrarMoto.setOnClickListener {
            motocicleta.registrar()
            atualizarLogs("Motocicleta registrada.")
        }

        binding.buttonExibirDetalhesMoto.setOnClickListener {
            val detalhes = motocicleta.exibirDetalhes()
            atualizarLogs(detalhes)
        }

        binding.buttonCalcularImpostoMoto.setOnClickListener {
            val imposto = motocicleta.calcularImposto()
            atualizarLogs("O imposto da motocicleta é: R$ $imposto")
        }

        binding.buttonRegistrarCarro.setOnClickListener {
            carro.registrar()
            atualizarLogs("Carro registrado.")
        }

        binding.buttonExibirDetalhesCarro.setOnClickListener {
            val detalhes = carro.exibirDetalhes()
            atualizarLogs(detalhes)
        }

        binding.buttonCalcularImpostoCarro.setOnClickListener {
            val imposto = carro.calcularImposto()
            atualizarLogs("O imposto do carro é: R$ $imposto")
        }
    }

    private fun atualizarLogs(mensagem: String) {
        binding.textLogs.text = "${binding.textLogs.text}\n$mensagem"
    }
}
