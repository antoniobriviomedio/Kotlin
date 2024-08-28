package com.example.aninterface.models

import com.example.aninterface.interfaces.Veiculo

class Carro(val marca: String, val modelo: String, val portas: Int) : Veiculo {

    override fun registrar() {
        println("Carro $marca $modelo registrado com sucesso.")
    }

    override fun exibirDetalhes(): String {
        return "Carro - Marca: $marca, Modelo: $modelo, Portas: $portas"
    }

    override fun calcularImposto(): Double {
        return if (portas > 2) 700.0 else 400.0
    }
}
