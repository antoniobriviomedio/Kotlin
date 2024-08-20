package com.example.controledecarros.model

class Taxi(
    marca: String,
    modelo: String,
    ano: Int,
    quilometragem: Int
) : Carro(marca, modelo, ano, quilometragem) {

    init {
        val anoAtual = 2024 // Substitua pelo ano atual correto
        if (anoAtual - ano > 10) {
            throw IllegalArgumentException("Um táxi não pode ter mais de 10 anos de uso.")
        }

        if (quilometragem > 200000) {
            throw IllegalArgumentException("Um táxi não pode ter mais de 200.000 km.")
        }

        println("Táxi $marca $modelo criado.")
    }
}
