package com.pathok.user.android.design_system

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RegularEditText(
    label: String,
    value: String,
    showRequiredText: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = ""
) {
    Column(modifier = modifier) {
        Text(
            text = buildAnnotatedString {
                append(label)
                withStyle(style = SpanStyle(color = Color.Red)) {
                    if (showRequiredText) append(" (Required)") else ""
                }
            },
            color = Color.White,
            modifier = Modifier.padding(4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder) },
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Gray,
                unfocusedIndicatorColor = Color.LightGray,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegularEditTextRequired() {
    var text by remember { mutableStateOf("") }
    PathokTheme {
        RegularEditText(
            label = "Bio",
            value = text,
            true,
            onValueChange = { text = it },
            placeholder = "Enter short bio of yourself"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegularEditTextOptional() {
    var text by remember { mutableStateOf("") }
    PathokTheme {
        RegularEditText(
            label = "Bio",
            value = text,
            false,
            onValueChange = { text = it },
            placeholder = "Enter short bio of yourself"
        )
    }
}
