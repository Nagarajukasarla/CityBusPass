package com.example.buspassapplication.components

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview


private val Any.Folder: ImageVector
    get() {
        TODO("Not yet implemented")
    }

@ExperimentalMaterial3Api
@Composable
fun ImagePickerInputField() {
    var imageName by remember { mutableStateOf("") }
    val context = LocalContext.current
    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageName = uri?.lastPathSegment ?: ""
    }

    OutlinedTextField(
        value = imageName,
        onValueChange = { },
        label = { Text("Image Name") },
        readOnly = true,
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Folder,
                contentDescription = "Select Image",
                modifier = Modifier.clickable {
                    imagePicker.launch("image/*")
                }
            )
        },
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewImagePickerInputField() {
    ImagePickerInputField()
}

