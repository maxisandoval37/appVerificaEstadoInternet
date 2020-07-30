package com.mxdigitalacademy.validarred

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private fun verficarConexionInternet(activity: AppCompatActivity):Boolean{
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return (networkInfo != null) && networkInfo.isConnected
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btVerficarRed = findViewById<Button>(R.id.btVerificar)
        btVerficarRed.setOnClickListener{

            if (verficarConexionInternet(this))
                Toast.makeText(this, "hay acceso a internet", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no hay acceso a internet", Toast.LENGTH_SHORT).show()
        }

    }
}