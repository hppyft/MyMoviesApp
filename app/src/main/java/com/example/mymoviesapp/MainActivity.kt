package com.example.mymoviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mymoviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.mainLabel.text = "Alo Alo"


        var variavel = 1
        var variavelTipada: Int = 1
        var variavelTipada2: Int = "a"

        var abc = "Eu sou uma variável"
        val def = "Eu sou um valor final"
        abc = "Eu posso mudar meu valor"
        def = "Eu não :("


        var a = 1.0 //Double
        var b = 1f //Float
        var c = 1 //Int
        var d = 1L //Long

        val myInt = 1_000_000
        val myCreditCard = 1234_1234_1234_1234
        val myMistake = 1234_

        val operacao = 5L + 5 //Long(5L) + Int(5) -> Long(10L)
        val operacao2 = 5.5 + 2 //Double(5.5) + Int(2) -> Double(7.5)
        val operacao3 = "a" + 5 //String(a) + Int(5) -> String(a5)
    }
}