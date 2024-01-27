package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.equalBtn.setOnClickListener {
            calculateresult()
        }
        binding.acBtn.setOnClickListener {
            clear()
        }
        binding.plusminusBtn.setOnClickListener {
            binding.textView.text = "-${binding.textView.text}"
        }
    }

    var newop=true
    fun numberEvent(view: View){
        if(newop){
            binding.textView.text=""
        }
        newop=false
        val buSelected = view as Button
        var tvNumber = binding.textView.text.toString()
        tvNumber += buSelected.text.toString()
        binding.textView.text = tvNumber
    }
    var operation="+"
    var oldNumber=""
    fun operationEvent(view: View){
        newop = true
        val buSelected = view as Button
        oldNumber = binding.textView.text.toString()
        operation= buSelected.text.toString()
    }
    var newNumber=""
    fun calculateresult(){
          newNumber = binding.textView.text.toString()
          var result:Double?=null
          when(operation){
              "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
              "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
              "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
              "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
              "%" -> result = oldNumber.toDouble() % newNumber.toDouble()
          }
          binding.textView.text=result.toString()
          newop=true
    }
    fun clear(){
        newop=true
        binding.textView.text="0"
        newNumber=""
        oldNumber=""
    }
}