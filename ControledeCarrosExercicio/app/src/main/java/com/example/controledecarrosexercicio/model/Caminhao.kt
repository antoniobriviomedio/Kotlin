package com.example.controledecarrosexercicio.model

class Caminhao(
    marca: String,
    modelo: String,
    ano: Int,
    quilometragem: Int,
    var capacidadeCarga: Int
) : Veiculo(marca, modelo, ano, quilometragem) {

    init {
        val anoAtual = 2024 // Substitua pelo ano atual correto
        if (anoAtual - ano > 15) {
            throw IllegalArgumentException("Atenção: Um caminhão não pode ter mais de 15 anos de uso!")
        }
    }
}
