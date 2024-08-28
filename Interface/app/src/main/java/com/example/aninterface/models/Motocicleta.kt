package com.example.aninterface.models

import com.example.aninterface.interfaces.Veiculo

class Motocicleta(val marca: String, val modelo: String, val cilindradas: Int) : Veiculo {

    override fun registrar() {
        println("Motocicleta $marca $modelo registrada com sucesso.")
    }

    override fun exibirDetalhes(): String {
        return "Motocicleta - Marca: $marca, Modelo: $modelo, Cilindradas: $cilindradas"
    }

    override fun calcularImposto(): Double {
        return if (cilindradas > 150) 500.0 else 300.0
    }
}
