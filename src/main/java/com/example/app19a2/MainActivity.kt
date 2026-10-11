package com.example.app19a2

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.os.Build
import androidx.appcompat.app.AlertDialog
import com.example.app19a2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        hideSystemUI()

        binding.btnPlay.setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
        }

        binding.btnSettings.setOnClickListener {
            showSettingsDialog()
        }
    }

    private fun showSettingsDialog() {
        val options = arrayOf("Créditos", "Borrar datos guardados", "Salir de la app")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ajustes")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> showCreditsDialog()
                1 -> deleteSavedData()
                2 -> finishAffinity()
            }
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun showCreditsDialog() {
        val credits = arrayOf(
            "Link 1: https://share.google/b8liEUbCJEotK840m",
            "Link 2: https://share.google/mLIvs4uVxoQETT8Ql"
        )
        AlertDialog.Builder(this)
            .setTitle("Créditos")
            .setItems(credits) { _, which ->
                val url = if (which == 0) "https://share.google/b8liEUbCJEotK840m" 
                          else "https://share.google/mLIvs4uVxoQETT8Ql"
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
            .setPositiveButton("Cerrar", null)
            .show()
    }

    private fun deleteSavedData() {
        val prefs = getSharedPreferences("GamePrefs", Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
        AlertDialog.Builder(this)
            .setMessage("Datos borrados correctamente")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun hideSystemUI() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }
}