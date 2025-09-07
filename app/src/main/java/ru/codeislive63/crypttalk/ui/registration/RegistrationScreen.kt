package ru.codeislive63.crypttalk.ui.registration

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true)
fun RegistrationScreen() {

    var expanded by remember {
        mutableStateOf(false)
    }

    var selectedCountry by remember {
        mutableStateOf("Belarus")
    }

    var countryCode by remember {
        mutableStateOf("+375")
    }

    var phoneNumber by remember {
        mutableStateOf("")
    }

    val focus = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .imePadding()
            .padding(horizontal = 36.dp, vertical = 28.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .widthIn(max = 560.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Enter your phone number",
                fontSize = 20.sp,
                color = colorResource(R.color.dark_turquoise),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = "Crypt Talk will need to verify your phone number",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(
                text = "What's my phone number?",
                color = colorResource(R.color.dark_turquoise)
            )

            Spacer(Modifier.height(16.dp))

            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = {
                    focus.clearFocus()
                    expanded = !expanded
                },
                modifier = Modifier
                    .widthIn(min = 200.dp, max = 560.dp)
            ) {
                TextField(
                    value = selectedCountry,
                    onValueChange = {},
                    readOnly = true,
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier
                        .widthIn(max = 200.dp)
                        .menuAnchor(
                            type = MenuAnchorType.PrimaryNotEditable,
                            enabled = true
                        ),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowDropDown,
                            contentDescription = null,
                            tint = colorResource(R.color.dark_turquoise),
                            modifier = Modifier.size(25.dp)
                        )
                    },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = colorResource(R.color.dark_turquoise),
                        unfocusedIndicatorColor = colorResource(R.color.dark_turquoise)
                    )
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf("USA", "Russia", "Canada", "China", "Poland").forEach { country ->
                        DropdownMenuItem(
                            text = { Text(country) },
                            onClick = {
                                selectedCountry = country
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = countryCode,
                    onValueChange = {
                        countryCode = it
                    },
                    modifier = Modifier.widthIn(min = 48.dp, max = 76.dp),
                    textStyle = LocalTextStyle.current.copy(
                        textAlign = TextAlign.Center
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = colorResource(R.color.dark_turquoise),
                        unfocusedIndicatorColor = colorResource(R.color.dark_turquoise)
                    )
                )

                Spacer(Modifier.width(8.dp))

                TextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it.filter { ch -> ch.isDigit() } },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("phone number") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = colorResource(R.color.dark_turquoise),
                        unfocusedIndicatorColor = colorResource(R.color.dark_turquoise)
                    )
                )
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = "Carrier charges may apply",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )

            Spacer(Modifier.height(20.dp))

            Button(
                onClick = {
                    focus.clearFocus()
                },
                shape = RoundedCornerShape(8.dp),
                enabled = phoneNumber.length >= 6,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.dark_turquoise)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Next")
            }
        }
    }
}
