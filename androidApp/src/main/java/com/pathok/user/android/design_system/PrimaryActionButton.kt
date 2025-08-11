package com.pathok.user.android.design_system

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * Created by Shuvo on 08/04/2025.
 */
@Composable
fun PrimaryActionButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .then(modifier),
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PreviewGreenPrimaryButton() {
    PathokTheme {
        PrimaryActionButton(text = "Proceed")
    }
}
