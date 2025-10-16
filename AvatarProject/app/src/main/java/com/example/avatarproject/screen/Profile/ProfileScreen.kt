package com.example.avatarproject.screen.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.avatarproject.R
import com.example.avatarproject.components.ActionButton
import com.example.avatarproject.components.CardText

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = viewModel()
){
    val userName = viewModel.userName.collectAsState()
    val clickCount = viewModel.clickCount.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
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
            text = userName.value,
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

        CardText(
            cardText = "Hi, I glad to see you!",
            count = clickCount.value,
            onClick = { viewModel.onCardClicked() }
        )
    }
}