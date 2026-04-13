package com.example.app19a2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.app19a2.databinding.ActivityTransitionBinding

class TransitionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransitionBinding
    private val PREFS_NAME = "GamePrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransitionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Obtener datos del Intent
        val level = intent.getIntExtra("LEVEL_COMPLETED", 1)
        val score = intent.getIntExtra("CURRENT_SCORE", 0)

        // Mostrar solo el número del nivel
        binding.tvLevelCompleted.text = level.toString()
        binding.tvTransitionScore.text = "Puntuación total: $score"

        // Lógica para el mensaje de motivación
        if (level == 3) {
            binding.tvMotivation.text = "Superar este nivel no es el final del camino, sino la prueba de que tu capacidad no tiene límites"
            binding.btnContinue.text = "Volver al inicio"
        } else {
            binding.tvMotivation.text = "Nuevos desafíos requieren una nueva versión de ti mismo. \n¡Deja atrás la comodidad del nivel anterior y abraza la exigencia del siguiente!"
            binding.btnContinue.text = "Siguiente nivel"
        }

        binding.btnContinue.setOnClickListener {
            if (level == 3) {
                // Al terminar el nivel 3, volvemos a la pantalla principal
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            } else {
                finish()
            }
        }

        binding.btnSettings.setOnClickListener {
            showSettingsDialog()
        }
    }

    private fun showSettingsDialog() {
        val options = arrayOf("Borrar datos guardados", "Salir de la app")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ajustes")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> deleteSavedData()
                1 -> finishAffinity()
            }
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun deleteSavedData() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
        
        AlertDialog.Builder(this)
            .setMessage("Datos borrados correctamente. El juego se reiniciará.")
            .setPositiveButton("OK") { _, _ ->
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
            .show()
    }
}