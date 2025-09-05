package ru.codeislive63.crypttalk.presentation.welcomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R

@Composable
@Preview(showSystemUi = true)
fun WelcomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Text(
            text = "Welcome to CryptTalk",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row {
            Text(
                text = "Read our",
                color = colorResource(R.color.gray)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Privacy Policy",
                color = colorResource(R.color.dark_turquoise)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Tap 'Agree and continue' to",
                color = colorResource(R.color.gray)
            )
        }

        Row {
            Text(
                text = "accept the",
                color = colorResource(R.color.gray)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Terms of Services",
                color = colorResource(R.color.dark_turquoise)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

            },
            modifier = Modifier.size(280.dp, 43.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.dark_turquoise)
            )
        ) {

            Text(
                text = "Agree and continue",
                fontSize = 16.sp
            )
        }
    }
}