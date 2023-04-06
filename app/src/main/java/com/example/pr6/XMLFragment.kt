package com.example.pr6

import android.graphics.drawable.Drawable
import android.icu.util.Calendar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.pr6.databinding.FragmentXMLBinding
import java.io.IOException


class XMLFragment : Fragment() {

    private var _binding: FragmentXMLBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentXMLBinding.inflate(inflater, container, false)

        binding.welcomeText.setOnClickListener {
            val userName = "Rostislav"
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)
            binding.welcomeText.text = getString(R.string.welcome, userName, hour, minute)
        }

        binding.textFlowers.setOnClickListener {
            binding.textFlowers.text = resources.getQuantityString(R.plurals.flowers, 21, 21)
        }

        binding.textDi.setOnClickListener {
            val di = resources.getStringArray(R.array.di)
            var allLanguages = ""
            for (lang in di)
                allLanguages += "$lang "
            binding.textDi.text = allLanguages
        }

        val imageView = binding.imCatWith
        val filename = "cat_with.jpg"
        try {
            val ims = context?.assets?.open(filename)
            val drawable = Drawable.createFromStream(ims, null)
            imageView.setImageDrawable(drawable)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}