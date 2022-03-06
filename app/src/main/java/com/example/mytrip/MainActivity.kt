package com.example.mytrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {//, View.OnClickListener {

//    override fun onClick(view: View) {
//        val id = view.id
//        if (id == R.id.btnCalcular) {
//            calculator()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btnQualcutar = findViewById<Button>(R.id.btnCalcular)
//        btnQualcutar.setOnClickListener(this)

        btnCalcular.setOnClickListener{
            view: View ->
            val id = view.id
            if (id == R.id.btnCalcular) {
                calculator()
            }
        }
    }


    private fun calculator() {
        if (isValid()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()
                val resultado = (distancia*preco)/autonomia

                editResultado.setText("total: ${resultado}")
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.Valores_invalidos), Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Toast.makeText(this, getString(R.string.Valores_invalidos), Toast.LENGTH_LONG).show()
        }
    }


    private fun isValid(): Boolean {
        return editDistancia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != ""
                && editAutonomia.text.toString() != "0"
    }

}