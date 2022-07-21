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

        b.textView4.text = "0"
        b.button16.setOnClickListener { pressNum("0") }
        b.button12.setOnClickListener { pressNum("1") }
        b.button13.setOnClickListener { pressNum("2") }
        b.button14.setOnClickListener { pressNum("3") }
        b.button8.setOnClickListener { pressNum("4") }
        b.button9.setOnClickListener { pressNum("5") }
        b.button10.setOnClickListener { pressNum("6") }
        b.button5.setOnClickListener { pressNum("7") }
        b.button4.setOnClickListener { pressNum("8") }
        b.button6.setOnClickListener { pressNum("9") }
        b.button17.setOnClickListener { }

        b.button2.setOnClickListener {
            n1 = b.textView4.text.toString().toInt()
            op = 4
            b.textView4.text = "0"
        }
        b.button7.setOnClickListener {
            n1 = b.textView4.text.toString().toInt()
            op = 3
            b.textView4.text = "0"

        }
        b.button11.setOnClickListener {
            n1 = b.textView4.text.toString().toInt()
            op = 2
            b.textView4.text = "0"

        }
        b.button15.setOnClickListener {
            n1 = b.textView4.text.toString().toInt()
            op = 1
            b.textView4.text = "0"

        }



        b.button18.setOnClickListener {
            n2 = b.textView4.text.toString().toInt()
            var result = when (op) {
                1 -> n1 + n2
                2 -> n1 - n2
                3 -> n1 * n2
                4 -> n1 / n2
                else -> 0
            }
            b.textView4.text = result.toString()
        }
        b.button.setOnClickListener { b.textView4.text ="0".toInt().toString() }



    }
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OP = 0

    }
    fun pressNum(n:String) {
        if (b.textView4.text.length < 9)
            b.textView4.text = b.textView4.text.toString().plus(n).toInt().toString()
    }

}
