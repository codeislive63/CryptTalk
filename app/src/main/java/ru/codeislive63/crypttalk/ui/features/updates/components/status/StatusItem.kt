package ru.codeislive63.crypttalk.ui.features.updates.components.status

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.codeislive63.crypttalk.R

@Composable
fun StatusItem(
    statusData: StatusData
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box {
            Image(
                painter = painterResource(statusData.image),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )

            if (statusData.isAddIconVisible) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.BottomEnd)
                        .padding(2.dp)
                        .background(
                            color = colorResource(R.color.dark_turquoise),
                            shape = RoundedCornerShape(12.dp)
                        )
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = statusData.displayName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = statusData.time,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}