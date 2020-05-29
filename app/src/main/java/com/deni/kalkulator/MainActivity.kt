package com.deni.kalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.deni.kalkulator.databinding.ActivityMainBinding
import javax.xml.transform.dom.DOMLocator

/**
 * Created by Deni Supriyatna (deni ace) on 29 - 05 - 2020.
 * Email : denisupriyatna01@gmail.com
 */

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
    }

    private fun isValid(): Boolean {
        var response: Boolean
        if (binding.angka1.text.length < 1) {
            Toast.makeText(this, "Angka 1 harus di isi", Toast.LENGTH_SHORT).show()
            response = false
        } else if (binding.angka2.text.length < 1) {
            Toast.makeText(this, "Angka 2 harus di isi", Toast.LENGTH_SHORT).show()
            response = false
        } else {
            response = true
        }
        return response
    }

    public fun tambah(view: View) {
        if (isValid()) {
            var angka1: Double? = binding.angka1.text.toString().toDouble()
            var angka2: Double? = binding.angka2.text.toString().toDouble()
            var hasil: Double? = angka2?.let { angka1?.plus(it) }
            binding.angkaHasil.setText(hasil?.toString())
        } else {
            binding.angkaHasil.setText("0")
        }

    }

    public fun kurang(view: View) {
        if (isValid()) {
            var angka1: Double = binding.angka1.text.toString().toDouble()
            var angka2: Double = binding.angka2.text.toString().toDouble()
            var hasil: Double = angka1.minus(angka2)
            binding.angkaHasil.setText(hasil.toString())
        }
    }

    public fun kali(view: View) {
        if (isValid()) {
            var angka1: Double = binding.angka1.text.toString().toDouble()
            var angka2: Double = binding.angka2.text.toString().toDouble()
            var hasil: Double = angka1.times(angka2)
            binding.angkaHasil.setText(hasil.toString())
        }
    }

    public fun bagi(view: View) {
        if (isValid()) {
            var angka1: Double = binding.angka1.text.toString().toDouble()
            var angka2: Double = binding.angka2.text.toString().toDouble()
            var hasil: Double = angka1.div(angka2)
            binding.angkaHasil.setText(hasil.toString())
        }
    }
}
