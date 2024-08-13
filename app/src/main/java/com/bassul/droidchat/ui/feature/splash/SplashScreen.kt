package com.bassul.droidchat.ui.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bassul.droidchat.R
import com.bassul.droidchat.ui.theme.BackgroundGradient
import com.bassul.droidchat.ui.theme.DroidChatTheme
import kotlinx.coroutines.delay

@Composable
fun SplashRoute(
    onNavigateToSignIn: () -> Unit,
) {
    SplashScreen()
    LaunchedEffect(Unit) {
        delay(2000)
        onNavigateToSignIn()
    }
}

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = BackgroundGradient)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,


        ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")

        Spacer(modifier = Modifier.height(77.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_safety),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(
                textAlign = TextAlign.Center,
                color = Color.White,
                text = stringResource(id = R.string.splash_safety_info),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = false, backgroundColor = 0xFF009688)
fun SplashScreenPreview() {
    DroidChatTheme {
        SplashScreen()
    }
}