package com.example.app19a2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.app19a2.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Placeholder for initial state
        resetUI()

        // Example: Setting answer listeners
        val buttons = listOf(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3, binding.btnAnswer4)
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                showFeedback(index == 0) // Assume first is correct for demo
            }
        }
    }

    private fun resetUI() {
        binding.layoutFeedback.visibility = View.INVISIBLE
        binding.btnNext.visibility = View.INVISIBLE
        // Reset button backgrounds
        binding.btnAnswer1.setBackgroundResource(R.drawable.bg_answer_default)
        binding.btnAnswer2.setBackgroundResource(R.drawable.bg_answer_default)
        binding.btnAnswer3.setBackgroundResource(R.drawable.bg_answer_default)
        binding.btnAnswer4.setBackgroundResource(R.drawable.bg_answer_default)
    }

    private fun showFeedback(isCorrect: Boolean) {
        binding.layoutFeedback.visibility = View.VISIBLE
        binding.btnNext.visibility = View.VISIBLE
        
        if (isCorrect) {
            binding.tvFeedbackText.text = "¡Bien hecho!"
            binding.tvFeedbackText.setTextColor(getColor(R.color.brand_green))
            // Highlight correct button
            binding.btnAnswer1.setBackgroundResource(R.drawable.bg_answer_correct)
        } else {
            binding.tvFeedbackText.text = "Respuesta incorrecta\n(explicación...)"
            binding.tvFeedbackText.setTextColor(getColor(R.color.brand_pink))
            // Example of highlighting wrong choice
            // binding.btnAnswerSelected.setBackgroundResource(R.drawable.bg_answer_incorrect)
        }
    }
}