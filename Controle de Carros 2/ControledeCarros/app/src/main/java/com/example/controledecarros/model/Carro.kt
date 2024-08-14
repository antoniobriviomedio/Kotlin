package com.example.controledecarros.model

open class Carro(
    var marca: String,
    var modelo: String,
    var ano: Int,
    var quilometragem: Int
) {
    init {
        println("Carro $marca $modelo criado.")
    }
}
