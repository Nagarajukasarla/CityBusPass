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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
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
        navController: NavHostController,
        viewModel: RoutePassApplicationViewModel = hiltViewModel(),
        currentUserId: String?
) {
    var fullName = viewModel.fullname.collectAsState()
    var guardian = viewModel.guardian.collectAsState()
    var dateOfBirth = viewModel.dateOfBirth.collectAsState()
    var phone = viewModel.phone.collectAsState()
    var email = viewModel.email.collectAsState()
    var aadhar = viewModel.aadhar.collectAsState()
    var address = viewModel.address.collectAsState()
    var district = viewModel.district.collectAsState()
    var mandal = viewModel.mandal.collectAsState()
    var village = viewModel.village.collectAsState()
    var fromPlace = viewModel.fromplace.collectAsState()
    var toPlace = viewModel.toplace.collectAsState()
    var pincode = viewModel.pincode.collectAsState()
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
            value = fullName.value,
            onValueChanged = {
                viewModel.updateFullName(it)
            }
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian.value,
            onValueChanged = {
                viewModel.updateGuardian(it)
            }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth.value,
            onValueChanged = {
                viewModel.updateDateOfBirth(it)
            }
        )
        DropDown(
            label = "gender",
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
            value = phone.value,
            onValueChanged = {
                viewModel.updatePhone(it)
            }
        )
        OutlinedInputField(
            label = "Email",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = email.value,
            onValueChanged = {
                viewModel.updateEmail(it)
            }
        )
        OutlinedInputField(
            label = "Aadhar no",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar.value,
            onValueChanged = {
                viewModel.updateAadhar(it)
            }
        )
        OutlinedInputField(
            label = "Applicant address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = address.value,
            onValueChanged = {
                viewModel.updateAddress(it)
            }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = district.value,
            onValueChanged = {
                viewModel.updateDistrict(it)
            }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandal.value,
            onValueChanged = {
                viewModel.updateMandal(it)
            }
        )
        OutlinedInputField(
            label = "village",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = village.value,
            onValueChanged = {
                viewModel.updateVillage(it)
            }
        )
        OutlinedInputField(
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincode.value,
            onValueChanged = {
                viewModel.updatePincode(it)
            }
        )
        BlueLabelledText(text = "Route Details")
        OutlinedInputField(
            label = "From Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fromPlace.value,
            onValueChanged = {
                viewModel.updateFromPlace(it)
            }
        )
        OutlinedInputField(
            label = "To Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = toPlace.value,
            onValueChanged = {
                viewModel.updateToPlace(it)
            }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.dp,
            height = 45.dp,
            borderShape = RoundedCornerShape(50)
        )
    }
}

//@ExperimentalMaterial3Api
//@Preview
//@Composable
//fun RoutePassApplicationFormScreenPreview() {
//    RoutePassApplicationFormScreen(navController = rememberNavController())
//}
