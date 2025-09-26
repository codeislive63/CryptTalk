package ru.codeislive63.crypttalk.ui.features.updates

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R
import ru.codeislive63.crypttalk.ui.components.navigation.BottomNavBar
import ru.codeislive63.crypttalk.ui.components.navigation.TopMenuAction
import ru.codeislive63.crypttalk.ui.components.navigation.TopNavBar
import ru.codeislive63.crypttalk.ui.features.updates.components.channel.ChannelData
import ru.codeislive63.crypttalk.ui.features.updates.components.channel.ChannelItem
import ru.codeislive63.crypttalk.ui.features.updates.components.status.StatusData
import ru.codeislive63.crypttalk.ui.features.updates.components.status.StatusItem

@Composable
@Preview(showSystemUi = true)
fun UpdatesScreen() {

    var isSearching by remember { mutableStateOf(false) }

    var query by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()

    val userCurrentStatus = StatusData(
        image = R.drawable.roberto,
        displayName = "Roberto",
        time = "Now",
        isAddIconVisible = true
    )

    val statusData = listOf(
        StatusData(
            image = R.drawable.christie,
            displayName = "Christie",
            time = "10 minutes ago",
        ),
        StatusData(
            image = R.drawable.eddy,
            displayName = "Eddy",
            time = "2 minutes ago",
        ),
        StatusData(
            image = R.drawable.leroy,
            displayName = "Leroy",
            time = "5 minutes ago",
        ),
    )

    val channelData = listOf(
        ChannelData(
            image = R.drawable.neat_roots,
            name = "Neat Roots",
            description = "Latest news in tech"
        ),
        ChannelData(
            image = R.drawable.puzzle_icon,
            name = "Food Lover",
            description = "Discover new recipes"
        ),
        ChannelData(
            image = R.drawable.meta,
            name = "Meta",
            description = "Explore the world"
        )
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                containerColor = colorResource(R.color.dark_turquoise),
                contentColor = Color.White,
                modifier = Modifier.size(65.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_photo_camera_24),
                    contentDescription = null
                )
            }
        },
        topBar = {
            TopNavBar(
                title = "Updates",
                isSearching = isSearching,
                query = query,
                onQueryChange = { query = it },
                onStartSearch = { isSearching = true },
                onCancelSearch = { isSearching = false; query = "" },
                onCameraClick = { },
                onMenuAction = { action ->
                    when (action) {
                        TopMenuAction.StatusPrivacy -> {

                        }

                        TopMenuAction.CreateChannel -> {

                        }

                        TopMenuAction.Settings -> {

                        }
                    }
                }
            )
        },
        bottomBar = {
            BottomNavBar()
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(it)
        ) {
            Text(
                text = "Status",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )

            StatusItem(userCurrentStatus)

            statusData.forEach { data ->
                StatusItem(statusData = data)
            }

            Spacer(modifier = Modifier.height(16.dp))

            HorizontalDivider(color = Color.Gray)

            Text(
                text = "Channels",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(text = "Stay updated on topics that matter to you. Find channels to follow below")

                Spacer(modifier = Modifier.height(32.dp))

                Text(text = "Find channels to follow")
            }

            Spacer(modifier = Modifier.height(16.dp))

            channelData.forEach { channelData ->
                ChannelItem(channelData = channelData)
            }
        }
    }
}