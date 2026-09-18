package com.example.a0_decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.a0_decisionmakingapp.ui.theme.A0DecisionMakingAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A0DecisionMakingAppTheme {
                DecisionMakingScreen(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
                )
            }
        }
    }
}




@Composable
fun DecisionMakingScreen(modifier: Modifier = Modifier) {

    var decision by remember { mutableStateOf("") }
    var clickCount by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Restaurant Decision Maker")
        Text("Decision: $decision")

        Button(
            onClick = {
                clickCount++
                decision = "Yes"
            }
        ) { Text("Yes") }

        Button(
            onClick = {
                clickCount++
                decision = "Maybe"
            }
        ) { Text("Maybe") }

        Button(
            onClick = {
                clickCount++
                decision = "No"
            }
        ) { Text("No") }
    }

}


@Preview(showBackground = true)
@Composable
fun previewing() {}