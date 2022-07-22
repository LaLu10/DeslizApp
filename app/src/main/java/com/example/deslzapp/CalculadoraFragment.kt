package com.example.deslzapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deslzapp.databinding.FragmentCalculadoraBinding
import com.example.deslzapp.databinding.FragmentIMCBinding


@Suppress("UNREACHABLE_CODE")
class CalculadoraFragment : Fragment() {
    private var _b: FragmentCalculadoraBinding?=null
    private val b get() = _b!!
    private var n1 = 0
    private var n2 = 0
    private var op = NO_OP
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _b= FragmentCalculadoraBinding.inflate(inflater,container,false)
        return b.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        b.tvPantalla.text = "0"
        b.btn0.setOnClickListener { pressNum("0") }
        b.btn1.setOnClickListener { pressNum("1") }
        b.btn2.setOnClickListener { pressNum("2") }
        b.btn3.setOnClickListener { pressNum("3") }
        b.btn4.setOnClickListener { pressNum("4") }
        b.btn5.setOnClickListener { pressNum("5") }
        b.btn6.setOnClickListener { pressNum("6") }
        b.btn7.setOnClickListener { pressNum("7") }
        b.btn8.setOnClickListener { pressNum("8") }
        b.btn9.setOnClickListener { pressNum("9") }
        b.btnPunto.setOnClickListener {"."}

        b.btnDiv.setOnClickListener {
            n1 = b.tvPantalla.text.toString().toInt()
            op = 4
            b.tvPantalla.text = "0"
        }
        b.btnMulti.setOnClickListener {
            n1 = b.tvPantalla.text.toString().toInt()
            op = 3
            b.tvPantalla.text = "0"

        }
        b.btnMenos.setOnClickListener {
            n1 = b.tvPantalla.text.toString().toInt()
            op = 2
            b.tvPantalla.text = "0"

        }
        b.btnMas.setOnClickListener {
            n1 = b.tvPantalla.text.toString().toInt()
            op = 1
            b.tvPantalla.text = "0"

        }



        b.btnIgual.setOnClickListener {
            n2 = b.tvPantalla.text.toString().toInt()
            var result = when (op) {
                1 -> n1 + n2
                2 -> n1 - n2
                3 -> n1 * n2
                4 -> n1 / n2
                else -> 0
            }
            b.tvPantalla.text = result.toString()
        }
        b.btnClear.setOnClickListener { b.tvPantalla.text ="0".toInt().toString() }



    }
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OP = 0

    }
    fun pressNum(n:String) {
        if (b.tvPantalla.text.length < 9)
            b.tvPantalla.text = b.tvPantalla.text.toString().plus(n).toInt().toString()
    }

}
