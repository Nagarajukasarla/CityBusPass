package com.example.buspassapplication.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.buspassapplication.routes.WalletScreenRoutes
import com.example.buspassapplication.screens.TransactionHistory.TransactionHistoryScreen
import com.example.buspassapplication.screens.pastTickets.PastTicketsScreen

fun NavGraphBuilder.walletScreenNavigationGraph(
    navController: NavHostController,
    currentUserId: String?
) {
    navigation(
        route = Graph.WALLET,
        startDestination = WalletScreenRoutes.TransactionScreen.route
    ) {
        composable(route = WalletScreenRoutes.TransactionScreen.route) {
            TransactionHistoryScreen(navController = navController, currentUserId = currentUserId)
        }
        composable(route = WalletScreenRoutes.PastTicketsScreen.route) {
            PastTicketsScreen(navController = navController, currentUserId = currentUserId)
        }
    }
}
