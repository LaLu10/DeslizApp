package com.example.deslzapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.res.ResourcesCompat.getColor
import com.example.deslzapp.databinding.FragmentIMCBinding
import com.google.android.material.snackbar.Snackbar


@Suppress("UNREACHABLE_CODE", "IMPLICIT_CAST_TO_ANY")
class IMCFragment : Fragment() {
    private var _binding: FragmentIMCBinding?=null
    private val binding get() = _binding!!
    private var height=150
    private var weight=75
    private var doubleHeight=2.25
    private var IMC=33.33
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentIMCBinding.inflate(inflater,container,false)
        return binding.root

        binding.sbAltura.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvContAlt.text = seek?.progress.toString().plus("/200")
                height=progress
            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) { calcIMC()
            }
        })
        binding.sbPeso.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.tvContPeso.text = seek?.progress.toString().plus("/150")
                weight=progress

            }
            override fun onStartTrackingTouch(p0: SeekBar?) {
            }
            override fun onStopTrackingTouch(p0: SeekBar?) { calcIMC()
            }
        })

    }
    fun calcIMC(){
        doubleHeight=height.times(height)/10000.0
        IMC=Math.round((weight/doubleHeight).times(100)).div(100.0)
        binding.textView5.text=IMC.toString()
        calcObesidad()
    }
    @SuppressLint("ResourceType")
    fun calcObesidad(){
        var msj= when(IMC){
            in 0.0..16.00 ->  Snackbar.make(binding.root, "Delgadez Severa", Snackbar.LENGTH_SHORT).setBackgroundTint(
                getColor(R.color.lila)
            ).show()
            in 16.00..16.99 ->Snackbar.make(binding.root, "Delgadez Moderada", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.azulclaro)).show()

            in 17.00..18.49 ->Snackbar.make(binding.root, "Delgadez Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.azul)).show()

            in 18.50..24.99 ->Snackbar.make(binding.root, "Peso Normal", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.verde)).show()

            in 25.00..29.99 ->Snackbar.make(binding.root, "PreObesidad", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.verdefeo)).show()

            in 30.00..34.99 ->Snackbar.make(binding.root, "Obesidad Leve", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.naranja))

            in 35.00..40.00 ->Snackbar.make(binding.root, "Obesidad Media", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.naranja2)).show()

            in 40.01..100000.0 ->Snackbar.make(binding.root, "Obesidad Mórbida", Snackbar.LENGTH_SHORT).setBackgroundTint(getColor(R.color.rojo)).show()

            else -> return
        }
    }

    private fun getColor(lila: Int): Int {
        return lila
    }
}