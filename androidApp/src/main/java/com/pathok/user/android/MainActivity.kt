package com.pathok.user.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pathok.user.Greeting
import com.pathok.user.android.design_system.PathokTheme
import com.pathok.user.android.design_system.bodyTextLGBold
import com.pathok.user.data.PathokSampleRepository
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val pathokSampleRepository: PathokSampleRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pathokSampleRepository.doSomething()

        setContent {
            PathokTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingView(Greeting().greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(message: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = bodyTextLGBold.copy(color = MaterialTheme.colorScheme.onSurface),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PathokTheme  {
        GreetingView(Greeting().greet())
    }
}
