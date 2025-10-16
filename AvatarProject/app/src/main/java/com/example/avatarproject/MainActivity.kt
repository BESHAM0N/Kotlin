package com.example.avatarproject
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.avatarproject.navigation.AppNavHost
import com.example.avatarproject.ui.theme.AvatarProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AvatarProjectTheme {
                AppNavHost()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserCardPreview() {
    AvatarProjectTheme {
        AppNavHost()
    }
}

