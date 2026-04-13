package com.example.app19a2

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String,
    val level: Int,
    val imageResId: Int? = null
)
