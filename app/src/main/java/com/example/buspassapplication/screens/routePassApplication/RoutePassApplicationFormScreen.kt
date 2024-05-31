package com.example.buspassapplication.screens.routePassApplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.BlueLabelledText
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold

@ExperimentalMaterial3Api
@Composable
fun RoutePassApplicationFormScreen(
    navController: NavHostController
) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var guardian by rememberSaveable { mutableStateOf("") }
    var dateOfBirth by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var aadhar by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var district by rememberSaveable { mutableStateOf("") }
    var mandal by rememberSaveable { mutableStateOf("") }
    var village by rememberSaveable { mutableStateOf("") }
    var fromPlace by rememberSaveable { mutableStateOf("") }
    var toPlace by rememberSaveable { mutableStateOf("") }
    var pincode by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackNavigationBar(navController = navController)
        NormalText(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 20.dp),
            value = "Route Pass Application",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = DarkGray
        )
        OutlinedInputField(
            label = "Full name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fullName,
            onValueChanged = { fullName = it }
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian,
            onValueChanged = { guardian = it }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth,
            onValueChanged = { dateOfBirth = it }
        )
        DropDown(
            options = listOf("Male", "Female", "Others"),
            value = "Gender",
            onItemSelected = { gender = it }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "Mobile",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = phone,
            onValueChanged = { phone = it }
        )
        OutlinedInputField(
            label = "Email",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = email,
            onValueChanged = { email = it }
        )
        OutlinedInputField(
            label = "Aadhar no",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar,
            onValueChanged = { aadhar = it }
        )
        OutlinedInputField(
            label = "Applicant address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = address,
            onValueChanged = { address = it }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = district,
            onValueChanged = { district = it }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandal,
            onValueChanged = { mandal = it }
        )
        OutlinedInputField(
            label = "village",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = village,
            onValueChanged = { village = it }
        )
        OutlinedInputField(
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincode,
            onValueChanged = { pincode = it }
        )
        BlueLabelledText(text = "Route Details")
        OutlinedInputField(
            label = "From Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fromPlace,
            onValueChanged = { fromPlace = it }
        )
        OutlinedInputField(
            label = "To Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = toPlace,
            onValueChanged = { toPlace = it }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.dp,
            height = 45.dp,
            borderShape = RoundedCornerShape(50)
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun RoutePassApplicationFormScreenPreview() {
    RoutePassApplicationFormScreen(navController = rememberNavController())
}