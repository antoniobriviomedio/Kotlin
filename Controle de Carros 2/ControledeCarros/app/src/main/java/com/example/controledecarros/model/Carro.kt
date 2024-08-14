package com.example.controledecarros.model

class Carro (
    private var marca: String,
    private var modelo: String,
    private var ano: Int,
    var quilometragem: Int
    // Quilometragem pode ser acessada diretamente
    ) {
        // Getters e Setters estilo Java
        fun getMarca(): String {
            return marca
        }

        fun setMarca(marca: String) {
            this.marca = marca
        }

        fun getModelo(): String {
            return modelo
        }

        fun setModelo(modelo: String) {
            this.modelo = modelo
        }

        fun getAno(): Int {
            return ano
        }

        fun setAno(ano: Int) {
            this.ano = ano
        }

        // Construtor
        init {
            println("Carro ${marca} ${modelo} criado.")
        }

    }

