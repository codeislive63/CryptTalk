package ru.codeislive63.crypttalk.ui.features.updates.components.status

data class StatusData(
    val image: Int,
    val displayName: String,
    val time: String,
    val isAddIconVisible: Boolean = false
)