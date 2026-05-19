package com.example.neveranother.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val pink = Color(0xFFE91E8C)
    val grey = Color(0xFF9E9E9E)

    NavigationBar(
        containerColor = Color.Transparent,
        tonalElevation = 0.dp,
        windowInsets = WindowInsets(0.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(50.dp)
            )
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(50.dp)
            )
    ) {
        // ========================= Cart ==============================
        NavigationBarItem(
            selected = currentRoute == "cart-screen",
            onClick = {
                navController.navigate("cart-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = "Cart",
                    tint = if (currentRoute == "cart-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )
        // ===================== Home =============================
        NavigationBarItem(
            selected = currentRoute == "home-screen",
            onClick = {
                navController.navigate("home-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Home",
                    tint = if (currentRoute == "home-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )
        // ======================= Profile ==============================
        NavigationBarItem(
            selected = currentRoute == "profile-screen",
            onClick = {
                navController.navigate("profile-screen") { launchSingleTop = true }
            },
            icon = {
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Profile",
                    tint = if (currentRoute == "profile-screen") pink else grey,
                    modifier = Modifier.size(32.dp)
                )
            },
            label = null
        )
    }
}
