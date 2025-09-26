package ru.codeislive63.crypttalk.ui.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R
import ru.codeislive63.crypttalk.ui.features.home.components.chat.ChatItem
import ru.codeislive63.crypttalk.ui.features.home.components.chat.ChatSection
import ru.codeislive63.crypttalk.ui.components.navigation.BottomNavBar

@Composable
@Preview(showSystemUi = true)
fun HomeScreen() {

    val chatData = listOf(
        ChatItem(
            name = "John Doe",
            image = R.drawable.john_doe,
            lastMessage = "Hi",
            lastMessageTime = "10:00 AM"
        ),

        ChatItem(
            name = "Ivan",
            image = R.drawable.ivan,
            lastMessage = "Hello",
            lastMessageTime = "9:00 PM"
        ),

        ChatItem(
            name = "Tanya",
            image = R.drawable.tanya,
            lastMessage = "I'm fine",
            lastMessageTime = "10:00 AM"
        ),

        ChatItem(
            name = "Helena",
            image = R.drawable.helena,
            lastMessage = "Queen of the dance floor",
            lastMessageTime = "10:00 AM"
        ),

        ChatItem(
            name = "John Doe",
            image = R.drawable.john_doe,
            lastMessage = "Hi",
            lastMessageTime = "10:00 AM"
        ),

        ChatItem(
            name = "Ivan",
            image = R.drawable.ivan,
            lastMessage = "Hello",
            lastMessageTime = "9:00 PM"
        ),

        ChatItem(
            name = "Tanya",
            image = R.drawable.tanya,
            lastMessage = "I'm fine",
            lastMessageTime = "10:00 AM"
        ),

        ChatItem(
            name = "Helena",
            image = R.drawable.helena,
            lastMessage = "Queen of the dance floor",
            lastMessageTime = "10:00 AM"
        ),
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                containerColor = colorResource(R.color.dark_turquoise),
                modifier = Modifier.size(65.dp),
                contentColor = Color.White
            ) {
                Icon(
                    painter = painterResource(R.drawable.chat_icon),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        bottomBar = {
            BottomNavBar()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "CryptTalk",
                    fontSize = 28.sp,
                    color = colorResource(R.color.dark_turquoise),
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp),
                    fontWeight = FontWeight.Bold
                )

                Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.camera_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.search_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }

                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.details_icon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }

            HorizontalDivider()

            LazyColumn {
                items(chatData) { it ->
                    ChatSection(chatItem = it)
                }
            }
        }
    }
}