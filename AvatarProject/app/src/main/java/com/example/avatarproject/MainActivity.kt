package com.example.avatarproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.avatarproject.ui.theme.AvatarProjectTheme

public class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarProjectTheme {
                UserCard()
            }
        }
    }
}

@Composable
private fun UserCard() {
    var showList = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
    {
        Button(
            onClick = { showList.value = true },
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(20.dp)
                .size(80.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_slime),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showList.value) {
            ListItem();
        }

        //Аватарка
        Image(
            painter = painterResource(id = R.drawable.ic_avatar),
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //ФИО
        Text(
            text = "Джураева Анастасия",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        // Должность
        Text(
            text = "Разработчик",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        )
        {
            ActionButton(
                iconRes = R.drawable.ic_baseline_mail,
                text = "Написать",
                onClick = { /* ... */ }
            )

            ActionButton(
                iconRes = R.drawable.ic_baseline_phone,
                text = "Позвонить",
                onClick = { /* ... */ }
            )
        }

        CardText("Hi, I glad to see you!")
    }
}

@Preview(showBackground = true)
@Composable
private fun UserCardPreview() {
    AvatarProjectTheme {
        UserCard()
    }
}

@Composable
private fun ActionButton(
    iconRes: Int,
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        ),
        modifier = modifier
    )
    {
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}

@Composable
private fun CardText(cardText: String) {
    val counter = remember { mutableStateOf(0) }
    val color = remember { mutableStateOf(Color.Black) }

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                when (++counter.value) {
                    10 -> color.value = Color.DarkGray
                    20 -> color.value = Color.Gray
                    30 -> color.value = Color.LightGray
                }
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(color = color.value)
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
                        text = counter.value.toString(),
                        modifier = Modifier.padding(start = 16.dp),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }
    }
}

@Composable
private fun ListItem() {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(
            listOf("Item 1", "Item 2", "End", "Cat")
        )
        { _, item ->
            Text(
                text = item,
                fontSize = 30.sp,
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}