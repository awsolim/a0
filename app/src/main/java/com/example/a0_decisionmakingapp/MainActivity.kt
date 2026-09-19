package com.example.a0_decisionmakingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a0_decisionmakingapp.ui.theme.A0DecisionMakingAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            A0DecisionMakingAppTheme {
                DecisionMakingScreen(modifier = Modifier
                    .fillMaxSize()
                    //.wrapContentSize(Alignment.Center)
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
        modifier = modifier.padding(top=60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Restaurant Decision Maker", fontSize = 30.sp)

        Row {
            Text("CCID: asolima1")
            Spacer(modifier = Modifier.width(10.dp))
            Text("ID: 1802557")
        }


        Spacer(modifier= Modifier.height(300.dp))
        Text("Decision: $decision", fontSize = 25.sp)

        Row {
            Button(
                onClick = {
                    clickCount++
                    decision = makeDecision(10)
                }
            ) { Text("I Want To Go") }

            Spacer(modifier= Modifier.width(2.dp))

            Button(
                onClick = {
                    clickCount++
                    decision = makeDecision(5)
                }
            ) { Text("Maybe") }

            Spacer(modifier= Modifier.width(2.dp))

            Button(
                onClick = {
                    clickCount++
                    decision = makeDecision(2)
                }
            ) { Text("I Don't Want To Go") }
        }

        Text("Clicks: $clickCount")

    }
}

fun makeDecision(boundary:Int): String {
    val rand = (1..20).random()
    return if (rand <= boundary) "Yes" else "No"
}

@Preview(showBackground = true)
@Composable
fun Previewing() {
    A0DecisionMakingAppTheme {
        DecisionMakingScreen(
            modifier = Modifier
                .fillMaxSize()

        )
    }
}