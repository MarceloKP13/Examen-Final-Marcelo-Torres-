package com.example.examenfinal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examenfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Listeners para los botones
        binding.botonsuma.setOnClickListener { operar(::sumar) }
        binding.botonresta.setOnClickListener { operar(::restar) }
        binding.botonmulti.setOnClickListener { operar(::multiplicar) }
        binding.botondivi.setOnClickListener { operar (::dividir) }
    }

    //Función para realizar las operaciones presionada por el botón
    private fun operar(operacion: (Double, Double) -> Double) {
        val num1 = binding.numero1.text.toString()
        val num2 = binding.numero2.text.toString()

        if (validarEntrada(num1, num2)){
            val resultadoOperacion = operacion (num1.toDouble(),num2.toDouble())
            binding.resultado.setText(resultadoOperacion.toString())
        }else{
            Toast.makeText(this, "¡¡Ingresa un número valido!!", Toast.LENGTH_SHORT).show()
        }
    }

    //Función para validar las entradas
    private fun validarEntrada(num1: String,num2:String):Boolean{
        return num1.isNotEmpty() && num2.isNotEmpty() && num1.toDoubleOrNull() != null && num2.toDoubleOrNull() != null
    }

    //Función para sumar
    private fun sumar(num1: Double, num2: Double):Double{
        return num1 + num2
    }
    //Función para restar
    private fun restar(num1: Double, num2: Double):Double{
        return num1 - num2
    }
    //Función para multiplicar
    private fun multiplicar(num1: Double, num2: Double):Double{
        return num1 * num2
    }
    //Función para dividir y mensaje al dividir por 0
    private fun dividir(num1: Double, num2: Double):Double{
        return if (num2 != 0.0){
            num1 / num2
        }else{
            Toast.makeText(this, "No es posible dividir por cero",Toast.LENGTH_SHORT).show()
            0.0
        }
    }
}