package com.saiseemala.examperformanceanalyzer

import kotlin.jvm.java


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saiseemala.examperformanceanalyzer.ui.theme.BlueShade
import com.saiseemala.examperformanceanalyzer.ui.theme.ExamPerformanceTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamPerformanceTheme {
                LoadingScreenCheck(::isUserLoggedIn)
            }
        }
    }

    private fun isUserLoggedIn(value: Int) {

        when (value) {
            2 -> {
                gotoSignInActivity(this)
            }

            1->{
                gotoHomeActivity(this)
            }

        }
    }
}

@Composable
fun LoadingScreenCheck(isUserLoggedIn: (value: Int) -> Unit) {
    var splashValue by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(3000)
        splashValue = false
    }

    if (splashValue) {
        ExamPerformanceSplash()
    } else {


            isUserLoggedIn.invoke(2)


    }
}



@Composable
fun ExamPerformanceSplash() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueShade),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.app_icon),
                contentDescription = "App Icon",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Exam Performance Analyzer",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "By Sai Seemala",
                color = Color.White,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .align(Alignment.CenterHorizontally)
            )


        }
    }

}


@Preview(showBackground = true)
@Composable
fun LoadingScreenPreview() {
    ExamPerformanceSplash()
}

fun gotoSignInActivity(context: Activity) {
    context.startActivity(Intent(context, SignInActivity::class.java))
    context.finish()
}

fun gotoHomeActivity(context: Activity) {
//    context.startActivity(Intent(context, HomeActivity::class.java))
//    context.finish()
}