package com.example.avatarproject.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.avatarproject.R


@Composable
fun CardText(
    cardText: String,
    count: Int,
    onClick: () -> Unit)
{
    val bg = when {
        count >= 30 -> Color.LightGray
        count >= 20 -> Color.Gray
        count >= 10 -> Color.DarkGray
        else -> Color.Black
    }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {onClick()},
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(color = bg)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_cat),
                    contentDescription = "number",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .clip(CircleShape)
                )

                Row {
                    Text(
                        text = cardText,
                        modifier = Modifier.padding(start = 16.dp),
                        style = TextStyle(color = Color.White)
                    )
                    Text(
                        text = count.toString(),
                        modifier = Modifier.padding(start = 16.dp),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}