package com.example.app19a2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.app19a2.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private var currentLevel = 1
    private var questionIndex = 0
    private var lives = 3
    private var score = 0
    private var initialLivesAtLevelStart = 3
    private var isAnswerCorrect = false
    private lateinit var questionList: List<Question>
    private val PREFS_NAME = "GamePrefs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        loadProgress()
        
        // --- CAMBIO PARA EL NIVEL 3 COMPLETADO ---
        if (currentLevel == 3 && questionIndex >= 10) { // Asumimos 10 preguntas por nivel
            showTransition(3, score)
        } else {
            loadLevel(currentLevel, questionIndex)
        }

        binding.btnNext.setOnClickListener {
            applyProgressAndGoNext()
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
        currentLevel = 1
        questionIndex = 0
        lives = 3
        score = 0
        initialLivesAtLevelStart = 3
        
        getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().remove("SAVED_QUESTION_IDS").apply()

        loadLevel(currentLevel, questionIndex)
        updateLivesUI()
        updateScoreUI()
        
        AlertDialog.Builder(this)
            .setMessage("Datos borrados correctamente")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun loadProgress() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        currentLevel = prefs.getInt("LEVEL", 1)
        questionIndex = prefs.getInt("INDEX", 0)
        lives = prefs.getInt("LIVES", 3)
        score = prefs.getInt("SCORE", 0)
        initialLivesAtLevelStart = prefs.getInt("INITIAL_LIVES_LEVEL", 3)
        updateLivesUI()
        updateScoreUI()
    }

    private fun saveProgress() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        with(prefs.edit()) {
            putInt("LEVEL", currentLevel)
            putInt("INDEX", questionIndex)
            putInt("LIVES", lives)
            putInt("SCORE", score)
            putInt("INITIAL_LIVES_LEVEL", initialLivesAtLevelStart)
            apply()
        }
    }

    private fun updateLivesUI() {
        val hearts = "❤️".repeat(if (lives > 0) lives else 0)
        binding.tvLives.text = "Vidas: $hearts"
    }

    private fun updateScoreUI() {
        binding.tvScore.text = "Puntos: $score"
    }

    override fun onPause() {
        super.onPause()
        saveProgress()
    }

    private fun loadLevel(level: Int, startIndex: Int = 0) {
        currentLevel = level
        questionIndex = startIndex
        
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val savedIdsString = prefs.getString("SAVED_QUESTION_IDS", null)

        if (savedIdsString != null) {
            val ids = savedIdsString.split(",").map { it.toInt() }
            questionList = QuestionRepository.getQuestionsByIds(ids)
        } else {
            questionList = QuestionRepository.getQuestionsByLevel(level)
            val idsString = questionList.joinToString(",") { it.id.toString() }
            prefs.edit().putString("SAVED_QUESTION_IDS", idsString).apply()
            
            if (startIndex == 0) {
                initialLivesAtLevelStart = lives
                saveProgress()
            }
        }
        
        if (questionIndex >= questionList.size) {
            // Si el índice es mayor o igual al tamaño de la lista, ya terminamos el nivel
            showTransition(currentLevel, score)
            return
        }
        
        displayQuestion()
    }

    private fun displayQuestion() {
        resetUI()
        val currentQuestion = questionList[questionIndex]

        binding.tvCounter.text = "Pregunta ${questionIndex + 1}/${questionList.size} - Nivel $currentLevel"
        binding.tvQuestion.text = currentQuestion.text
        
        val imageName = "q${currentQuestion.id}"
        val resId = resources.getIdentifier(imageName, "drawable", packageName)
        
        if (resId != 0) {
            binding.imgQuestion.setImageResource(resId)
        } else {
            binding.imgQuestion.setImageResource(R.drawable.ic_muscle_arm)
        }

        val buttons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        
        buttons.forEachIndexed { index, button ->
            button.text = currentQuestion.options[index]
            button.setOnClickListener {
                checkAnswer(index)
            }
        }
    }

    private fun checkAnswer(selectedIndex: Int) {
        val currentQuestion = questionList[questionIndex]
        isAnswerCorrect = selectedIndex == currentQuestion.correctOptionIndex
        
        showFeedback(isAnswerCorrect, currentQuestion.explanation, currentQuestion.correctOptionIndex, selectedIndex)
    }

    private fun applyProgressAndGoNext() {
        if (isAnswerCorrect) {
            score += 10
        } else {
            lives--
        }
        
        updateScoreUI()
        updateLivesUI()

        if (lives <= 0) {
            gameOver()
            return
        }

        val nextIndex = questionIndex + 1
        var savedLevel = currentLevel
        var savedIndex = nextIndex
        var savedScore = score
        var savedLives = lives

        if (nextIndex >= questionList.size) {
            val levelJustFinished = currentLevel
            
            if (lives == initialLivesAtLevelStart) {
                score *= 2
                savedScore = score
                updateScoreUI()
            }

            if (currentLevel < 3) {
                savedLevel++
                savedIndex = 0
            } else {
                // Al completar el Nivel 3, guardamos que terminó.
                savedLevel = 3
                savedIndex = 10 // Marcamos como nivel 3 terminado
            }
            getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().remove("SAVED_QUESTION_IDS").apply()
            
            currentLevel = savedLevel
            questionIndex = savedIndex
            score = savedScore
            lives = savedLives
            saveProgress()
            
            showTransition(levelJustFinished, savedScore)
        } else {
            questionIndex = nextIndex
            saveProgress()
            displayQuestion()
        }
    }

    private fun resetUI() {
        binding.layoutFeedback.visibility = View.INVISIBLE
        binding.btnNext.visibility = View.INVISIBLE
        binding.btnNext.isEnabled = true
        
        val buttons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        buttons.forEach { 
            it.setBackgroundResource(R.drawable.bg_answer_default)
            it.isEnabled = true
        }
    }

    private fun showFeedback(isCorrect: Boolean, explanation: String, correctIndex: Int, selectedIndex: Int) {
        binding.layoutFeedback.visibility = View.VISIBLE
        binding.btnNext.visibility = View.VISIBLE
        
        val buttons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        buttons.forEach { it.isEnabled = false }

        if (isCorrect) {
            binding.tvFeedbackText.text = "¡Bien hecho!"
            binding.tvFeedbackText.setTextColor(getColor(R.color.brand_green))
            binding.imgFeedbackIcon.setImageResource(android.R.drawable.checkbox_on_background)
        } else {
            binding.tvFeedbackText.text = "Incorrecto: $explanation"
            binding.tvFeedbackText.setTextColor(getColor(R.color.brand_pink))
            binding.imgFeedbackIcon.setImageResource(android.R.drawable.ic_delete)
            buttons[selectedIndex].setBackgroundResource(R.drawable.bg_answer_incorrect)
        }
        
        buttons[correctIndex].setBackgroundResource(R.drawable.bg_answer_correct)
    }

    private fun gameOver() {
        binding.btnNext.isEnabled = false
        AlertDialog.Builder(this)
            .setTitle("¡Juego Terminado!")
            .setMessage("Has perdido todas tus vidas. Puntos totales: $score\nDebes empezar de nuevo.")
            .setCancelable(false)
            .setPositiveButton("Reintentar") { _, _ ->
                currentLevel = 1
                questionIndex = 0
                lives = 3
                score = 0
                initialLivesAtLevelStart = 3
                getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit().remove("SAVED_QUESTION_IDS").apply()
                saveProgress()
                loadLevel(currentLevel, questionIndex)
                updateLivesUI()
                updateScoreUI()
            }
            .show()
    }

    private fun showTransition(finishedLevel: Int, scoreToShow: Int) {
        val intent = Intent(this, TransitionActivity::class.java)
        intent.putExtra("LEVEL_COMPLETED", finishedLevel)
        intent.putExtra("CURRENT_SCORE", scoreToShow)
        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            if (currentLevel < 3 || (currentLevel == 3 && questionIndex < 10)) {
                updateScoreUI()
                updateLivesUI()
                loadLevel(currentLevel, questionIndex)
            } else {
                currentLevel = 1
                questionIndex = 0
                score = 0
                lives = 3
                saveProgress()
                finish()
            }
        }
    }
}