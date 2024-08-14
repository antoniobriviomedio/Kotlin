import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var veiculo: Carro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configurando o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCriar.setOnClickListener {
            try {
                val marca = binding.editMarca.text.toString()
                val modelo = binding.editModelo.text.toString()
                val ano = binding.editAno.text.toString().toInt()
                val quilometragem = binding.editQuilometragem.text.toString().toInt()

                // Instanciar o objeto com base na seleção do usuário
                Carro(marca, modelo, ano, 0)
                mostrarDetalhes()

            } catch (e: NumberFormatException) {
                binding.textDetalhes.text = e.message
            }
        }

        binding.buttonAtualizarQuilometragem.setOnClickListener {
            val novaQuilometragem = binding.editQuilometragem.text.toString().toInt()

            try {
                veiculo.quilometragem = novaQuilometragem
                mostrarDetalhes()
            } catch (e: NumberFormatException) {
                binding.textDetalhes.text = e.message
            }
        }
    }

    private fun mostrarDetalhes() {
        val detalhes = """
            Tipo: ${if (veiculo is Taxi) "Táxi" else "Carro"}
            Marca: ${veiculo.marca}
            Modelo: ${veiculo.modelo}
            Ano: ${veiculo.ano}
            Quilometragem: ${veiculo.quilometragem}
        """.trimIndent()

        binding.textDetalhes.text = detalhes
    }
}
