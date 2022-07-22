package com.example.deslzapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
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
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        val msj= when(IMC){
            in 0.0..15.99 -> ContextCompat.getColor(requireContext(), R.color.lila)
            in 16.0..16.99 -> ContextCompat.getColor(requireContext(), R.color.azulclaro)
            in 17.0..18.49 -> ContextCompat.getColor(requireContext(), R.color.azul)
            in 18.5..24.99 -> ContextCompat.getColor(requireContext(), R.color.verde)
            in 25.0..29.99 -> ContextCompat.getColor(requireContext(), R.color.verdefeo)
            in 30.0..34.99 -> ContextCompat.getColor(requireContext(), R.color.naranja)
            in 35.0..39.99 -> ContextCompat.getColor(requireContext(), R.color.naranja2)
            else -> ContextCompat.getColor(requireContext(), R.color.rojo)
        }
        val obesidad = when (IMC){
            in 0.0..15.99 -> "DELGADEZ SEVERA"
            in 16.0..16.99 -> "DELGADEZ MODERADA"
            in 17.0..18.49 -> "DELGADEZ LEVE"
            in 18.5..24.99 -> "NORMAL"
            in 25.0..29.99 -> "PREOBESIDAD"
            in 30.0..34.99 -> "OBESIDAD LEVE"
            in 35.0..39.99 -> "OBESIDAD MEDIA"
            else -> "OBESIDAD MÓRBIDA"
        }

        val sb = Snackbar.make(binding.root, obesidad, Snackbar.LENGTH_LONG)
        sb.setTextColor(Color.WHITE)
        sb.setBackgroundTint(msj)
        sb.setActionTextColor(Color.DKGRAY)
        sb.setAction("Ver Tabla"){
            showTable()
        }
        sb.show()
    }
    fun showTable(){
        val dialog = TableFragment()
        dialog.show(parentFragmentManager, "TablaPeso")
    }


    }