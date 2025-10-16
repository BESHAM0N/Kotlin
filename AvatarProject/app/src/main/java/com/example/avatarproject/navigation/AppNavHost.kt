package com.example.avatarproject.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.avatarproject.R
import com.example.avatarproject.screen.Profile.ProfileScreen
import com.example.avatarproject.screen.Catalog.CatalogScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Profile.path
    ) {
        profileScreen(onOpenCatalog = { navController.navigate(Routes.Catalog.path) })
        catalogScreen(onBack = { navController.popBackStack() })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.profileScreen(
    onOpenCatalog: () -> Unit
) {
    composable(Routes.Profile.path) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Профиль") },
                    actions = {
                        IconButton(onClick = onOpenCatalog) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_slime),
                                contentDescription = "Открыть каталог"
                            )
                        }
                    }
                )
            }
        )
        { padding ->
            ProfileScreen(
                modifier = Modifier.padding(padding),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun NavGraphBuilder.catalogScreen(
    onBack: () -> Unit
) {
    composable(Routes.Catalog.path) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Каталог") },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "Назад"
                            )
                        }
                    }
                )
            }
        ) { padding ->
            CatalogScreen(
                modifier = Modifier.padding(padding)
            )
        }
    }
}
