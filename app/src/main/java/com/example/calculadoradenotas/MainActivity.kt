package com.example.calculadoradenotas

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btCalcular: Button = botaoCalcular
        val btSair: Button = sair

        btCalcular.setOnClickListener {
            val notaUm: Int = Integer.parseInt(nota1.text.toString())
            val notaDois: Int = Integer.parseInt(nota2.text.toString())
            val media: Int = (notaUm + notaDois) / 2
            val faltas: Int = Integer.parseInt(faltas.text.toString())
            val builder = AlertDialog.Builder(this)
            val dialogBuilder = AlertDialog.Builder(this)
            if (media >= 6 && faltas <= 10) {
            dialogBuilder.setMessage("Aprovado")
                .setCancelable(false)
                .setPositiveButton("OK", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()})
            val alert = dialogBuilder.create()
            alert.setTitle("Resultado")
            alert.show()
            } else {
                dialogBuilder.setMessage("Reprovado")
                    .setCancelable(false)
                    .setPositiveButton("OK", DialogInterface.OnClickListener {
                            dialog, id -> dialog.cancel()})
                val alert = dialogBuilder.create()
                alert.setTitle("Resultado")
                alert.show()
            }
        }

        btSair.setOnClickListener {
            finish()
        }
    }
}