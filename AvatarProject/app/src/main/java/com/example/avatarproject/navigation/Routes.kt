package com.example.avatarproject.navigation

sealed class Routes(val path: String) {
    data object Profile : Routes("profile")
    data object Catalog : Routes("catalog")
}