package ru.codeislive63.crypttalk.ui.features.communities

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R
import ru.codeislive63.crypttalk.ui.components.navigation.BottomNavBar
import ru.codeislive63.crypttalk.ui.components.navigation.TopNavBar
import ru.codeislive63.crypttalk.ui.features.communities.components.community.CommunityData
import ru.codeislive63.crypttalk.ui.features.communities.components.community.CommunityItem

@Composable
@Preview(showSystemUi = true)
fun CommunitiesScreen() {

    var isSearching by remember { mutableStateOf(false) }

    var query by remember { mutableStateOf("") }

    val communities = listOf(
        CommunityData(
            image = R.drawable.puzzle_icon,
            communityName = "Tech Enthusiasts",
            members = "256 members"
        ),
        CommunityData(
            image = R.drawable.puzzle_icon,
            communityName = "Photography Lovers",
            members = "128 members"
        ),
        CommunityData(
            image = R.drawable.puzzle_icon,
            communityName = "Traveller Community",
            members = "64 members"
        ),
    )

    Scaffold(
        topBar = {
            TopNavBar(
                title = "Communities",
                isSearching = isSearching,
                query = query,
                onQueryChange = { query = it },
                onStartSearch = { isSearching = true },
                onCancelSearch = { isSearching = false; query = "" },
                onCameraClick = { },
                onMenuAction = { },
                showCamera = false
            )
        },
        bottomBar = {
            BottomNavBar()
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.dark_turquoise)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Start a new Community",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Your Communities",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )

            LazyColumn {
                items(communities) { communityData ->
                    CommunityItem(communityData = communityData)
                }
            }
        }
    }
}
