package com.example.buspassapplication.screens.Billing

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp

@Composable
fun BillingScreen(
    navController: NavHostController,
    currentUserId: String?
){
    Column(
        modifier = Modifier.padding(bottom = 30.toResponsiveDp()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackNavigationBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.toResponsiveDp(), top = 20.toResponsiveDp(), end = 30.toResponsiveDp())
        ) {
            Column {
                NormalText(
                    modifier = Modifier.padding(top = 20.toResponsiveDp(), bottom = 0.toResponsiveDp(), start = 10.toResponsiveDp()),
                    value = "Bill Summary",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Black
                )
                Spacer(modifier = Modifier.height(20.toResponsiveDp()))
                Column {
                   TODO("Add list of bills")
                }
            }
        }
    }
}
