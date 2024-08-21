package com.example.controledecarrosexercicio.model

class Motocicleta(
    marca: String,
    modelo: String,
    ano: Int,
    quilometragem: Int,
    var cilindradas: Int
) : Veiculo(marca, modelo, ano, quilometragem) {

    init {
        if (quilometragem > 50000) {
            throw IllegalArgumentException("Atenção: Uma moto não pode ter mais de 50.000 km!")
        }
    }
}
