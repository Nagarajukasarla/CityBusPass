package com.example.buspassapplication.routes

sealed class TopBarRoutes(val route: String) {
    object Settings: TopBarRoutes(route = "settings_screen")
}
