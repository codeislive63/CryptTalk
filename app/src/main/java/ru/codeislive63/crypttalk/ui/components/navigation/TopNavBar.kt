package ru.codeislive63.crypttalk.ui.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R

@Composable
fun TopNavBar(
    title: String,
    query: String,
    isSearching: Boolean,
    onQueryChange: (String) -> Unit,
    onStartSearch: () -> Unit,
    onCancelSearch: () -> Unit,
    onCameraClick: () -> Unit,
    onMenuAction: (TopMenuAction) -> Unit,
    showCamera: Boolean = true
) {
    var isMenuOpen by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            if (isSearching) {
                TextField(
                    value = query,
                    onValueChange = onQueryChange,
                    placeholder = { Text("Search") },
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.padding(start = 12.dp),
                    singleLine = true
                )
            } else {
                Text(
                    text = title,
                    modifier = Modifier.padding(start = 12.dp, top = 4.dp),
                    color = Color.Black,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(Modifier.weight(1f))

            if (isSearching) {
                IconButton(onClick = { onCancelSearch() }) {
                    Icon(
                        painter = painterResource(R.drawable.cross_icon),
                        contentDescription = "Close search",
                        modifier = Modifier.size(15.dp)
                    )
                }
            } else {
                if (showCamera) {
                    IconButton(onClick = onCameraClick) {
                        Icon(
                            painter = painterResource(R.drawable.camera_icon),
                            contentDescription = "Camera",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                IconButton(onClick = onStartSearch) {
                    Icon(
                        painter = painterResource(R.drawable.search_icon),
                        contentDescription = "Search",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Box {
                    IconButton(onClick = { isMenuOpen = true }) {
                        Icon(
                            painter = painterResource(R.drawable.details_icon),
                            contentDescription = "Menu",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    DropdownMenu(
                        expanded = isMenuOpen,
                        onDismissRequest = { isMenuOpen = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Status Privacy") },
                            onClick = {
                                isMenuOpen = false; onMenuAction(TopMenuAction.StatusPrivacy)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Create Channel") },
                            onClick = {
                                isMenuOpen = false; onMenuAction(TopMenuAction.CreateChannel)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Settings") },
                            onClick = { isMenuOpen = false; onMenuAction(TopMenuAction.Settings) }
                        )
                    }
                }
            }
        }

        HorizontalDivider()
    }
}

//@Composable
//@Preview(showSystemUi = true)
//fun TopNavBar() {
//
//    var isSearching by remember {
//        mutableStateOf(false)
//    }
//
//    var search by remember {
//        mutableStateOf("")
//    }
//
//    var isMenuOpen by remember {
//        mutableStateOf(false)
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .statusBarsPadding()
//    ) {
//        Column {
//            Row {
//                if (isSearching) {
//                    TextField(
//                        value = search,
//                        onValueChange = {
//                            search = it
//                        },
//                        placeholder = {
//                            Text(text = "Search")
//                        },
//                        colors = TextFieldDefaults.colors(
//                            focusedContainerColor = Color.Transparent,
//                            unfocusedContainerColor = Color.Transparent,
//                            focusedIndicatorColor = Color.Transparent,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        modifier = Modifier.padding(start = 12.dp),
//                        singleLine = true
//                    )
//                } else {
//                    Text(
//                        text = "Updates",
//                        modifier = Modifier.padding(start = 12.dp, top = 4.dp),
//                        color = Color.Black,
//                        fontSize = 28.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Spacer(modifier = Modifier.weight(1f))
//
//                if (isSearching) {
//                    IconButton(
//                        onClick = {
//                            isSearching = false
//                            search = ""
//                        }
//                    ) {
//                        Icon(
//                            painter = painterResource(R.drawable.cross_icon),
//                            contentDescription = null,
//                            modifier = Modifier.size(15.dp)
//                        )
//                    }
//                } else {
//                    IconButton(onClick = { }) {
//                        Icon(
//                            painter = painterResource(R.drawable.camera_icon),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//
//                    IconButton(onClick = { isSearching = true }) {
//                        Icon(
//                            painter = painterResource(R.drawable.search_icon),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//                    }
//
//                    IconButton(onClick = {
//                        isMenuOpen = true
//                    }) {
//                        Icon(
//                            painter = painterResource(R.drawable.details_icon),
//                            contentDescription = null,
//                            modifier = Modifier.size(24.dp)
//                        )
//
//                        DropdownMenu(
//                            expanded = isMenuOpen,
//                            onDismissRequest = { isMenuOpen = false }
//                        ) {
//                            DropdownMenuItem(
//                                text = { Text(text = "Status Privacy") },
//                                onClick = { isMenuOpen = false }
//                            )
//
//                            DropdownMenuItem(
//                                text = { Text(text = "Create Channel") },
//                                onClick = { isMenuOpen = false }
//                            )
//
//                            DropdownMenuItem(
//                                text = { Text(text = "Settings") },
//                                onClick = { isMenuOpen = false }
//                            )
//                        }
//                    }
//                }
//            }
//
//            HorizontalDivider()
//        }
//    }
//}