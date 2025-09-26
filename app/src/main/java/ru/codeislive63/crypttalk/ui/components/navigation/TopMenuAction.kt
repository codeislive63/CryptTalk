package ru.codeislive63.crypttalk.ui.components.navigation

sealed class TopMenuAction {
    data object StatusPrivacy : TopMenuAction()
    data object CreateChannel : TopMenuAction()
    data object Settings : TopMenuAction()
}