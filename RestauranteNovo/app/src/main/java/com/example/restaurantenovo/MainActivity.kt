package com.example.restaurantenovo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantenovo.adapter.FoodAdapter
import com.example.restaurantenovo.databinding.ActivityMainBinding
import com.example.restaurantenovo.model.Food

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodList: MutableList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        recyclerView = binding.recyclerFood
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Inicializar a lista de alimentos
        foodList = mutableListOf(
            Food(R.drawable.food1, "Prato Feito com Fritas", "Fritas e Frango", "20,00"),
            Food(R.drawable.food2, "Sushi", "Os melhores rolls do bairro", "60,00"),
            Food(R.drawable.food3, "Prato Feito Carne Assada", "Carne assada, farofa e torta salgada", "60,00")

        // Adicione mais itens de comida aqui
        )

        // Configurar o adapter com a lista de alimentos
        foodAdapter = FoodAdapter(this, foodList)
        recyclerView.adapter = foodAdapter
    }
}