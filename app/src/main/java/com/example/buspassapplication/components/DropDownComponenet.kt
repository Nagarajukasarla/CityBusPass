package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import toResponsiveSp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(
    label: String,
    options: List<String>,
    value: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth()
) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(value) }
    Column(
        modifier = modifier
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        )
        {
            OutlinedTextField(
                modifier = Modifier.menuAnchor(),
                value = value.ifEmpty { selectedText },
                onValueChange = {  },
                readOnly = true,
                label = {
                    Text(
                        text = label,
                        style = TextStyle(
                            letterSpacing = 0.3.toResponsiveSp()
                        )
                    )
                },
                textStyle = TextStyle(
                    letterSpacing = 0.7.toResponsiveSp(),
                    color = DarkGray
                ),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = NavyBlue,
                    focusedLabelColor = NavyBlue,
                    cursorColor = DarkGray,
                    focusedSupportingTextColor = DarkGray,
                    focusedTrailingIconColor = Color.White,
                    containerColor = Color.White
                ),
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }) {
                options.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = text,
                                style = TextStyle(fontSize = 16.toResponsiveSp())
                            )
                        },
                        onClick = {
                            selectedText = options[index]
                            onItemSelected(selectedText)
                            isExpanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

    }
}
