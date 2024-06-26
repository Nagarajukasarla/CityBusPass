package com.example.buspassapplication.screens.login

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.routes.AuthenticationScreenRoutes
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import toResponsiveDp
import toResponsiveSp

@SuppressLint("StateFlowValueCalledInComposition")
@ExperimentalMaterial3Api
@Composable
fun LoginScreen(
    navController: NavHostController,
    viewModel: LoginViewModel = hiltViewModel(),
){

    var popupStatus = viewModel.showPopup.collectAsState()
    var email = viewModel.email.collectAsState()
    var password = viewModel.password.collectAsState()
    var contentOnFirstLine = viewModel.popupMessageOnFirstLine.collectAsState()
    var contentOnSecondLine = viewModel.popupMessageOnSecondLine.collectAsState()
    var popupTitle = viewModel.popupTitle.collectAsState()


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .verticalScroll(rememberScrollState())
            .padding(28.toResponsiveDp())
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(
                value = "Hey there,",
                isSmall = true
            )
            HeadingText(
                value = "Welcome back!",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(20.toResponsiveDp()))
            OutlinedInputField(
                label = "Email",
                modifier = Modifier.width(330.toResponsiveDp()),
                value = email.value,
                onValueChanged = {
                    viewModel.updateEmail(it)
                }
            )
            Spacer(modifier = Modifier.height(20.toResponsiveDp()))
            PasswordField(
                modifier = Modifier.width(330.toResponsiveDp()),
                label = "Password",
                value = password.value,
                onValueChange = {
                    viewModel.updatePassword(it)
                }
            )
            Spacer(modifier = Modifier.height(25.toResponsiveDp()))
            Row {
                NormalText(
                    value= "Forgot password? ",
                    fontSize = 15.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
                NormalText(
                    value= "Reset",
                    fontSize = 15.toResponsiveSp(),
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.clickable {
                        navController.navigate(route = AuthenticationScreenRoutes.ForgotPassword.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            Spacer(modifier = Modifier.height(25.toResponsiveDp()))
            PrimaryButton(
                text = "Submit",
                width = 280.toResponsiveDp(),
                height = 45.toResponsiveDp(),
                borderShape = RoundedCornerShape(50),
                onClick = {
                    viewModel.onLoginClick(navController = navController)
                }
            )
            Row(
                modifier = Modifier.padding(top = 15.toResponsiveDp())
            ) {
                NormalText(
                    value = "Not a member? ",
                    fontSize = 16.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    modifier = Modifier
                )
                NormalText(
                    value = "Signup",
                    fontSize = 16.toResponsiveSp(),
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    modifier = Modifier.clickable {
                        navController.navigate(route = AuthenticationScreenRoutes.Signup.route) {
                            launchSingleTop = true
                        }
                    }
                )
            }
            if (popupStatus.value) {
                Popup(
                    onDismissRequest = {
                        viewModel.updatePopupStatus(false)
                    },
                    onConfirmRequest = {
                        viewModel.updatePopupStatus(false)
                    },
                    title = popupTitle.value.ifEmpty { "Invalid Credentials" },
                    contentOnFirstLine = contentOnFirstLine.value,
                    contentOnSecondLine = contentOnSecondLine.value
                )
            }
        }
    }
}

//@ExperimentalMaterial3Api
//@Preview
//@Composable
//fun LoginPreview(){
//    LoginScreen(navController = rememberNavController())
//}
