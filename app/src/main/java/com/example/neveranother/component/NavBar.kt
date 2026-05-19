package com.example.neveranother.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.neveranother.R


@Composable
fun BottomNavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val activeNavBarItemColor = Color.Black
    val inactiveNavBarItemColor = Color.Black.copy(alpha = 0.40f)

    NavigationBar(
        containerColor = Color.Transparent,
        tonalElevation = 0.dp,
        windowInsets = WindowInsets(0.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 1.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                width = 0.1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(10.dp)
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
                    painter = painterResource(id = R.drawable.carticon),
                    contentDescription = "Cart",
                    tint = if (currentRoute == "cart-screen") activeNavBarItemColor else inactiveNavBarItemColor,
                    modifier = Modifier.size(40.dp)
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            ),
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
                    painter = painterResource(id = R.drawable.homeicon),
                    contentDescription = "Home",
                    tint = if (currentRoute == "home-screen") activeNavBarItemColor else inactiveNavBarItemColor,
                    modifier = Modifier.size(40.dp)
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            ),
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
                    painter = painterResource(id = R.drawable.personicon),
                    contentDescription = "Profile",
                    tint = if (currentRoute == "profile-screen") activeNavBarItemColor else inactiveNavBarItemColor,
                    modifier = Modifier.size(40.dp)
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.Transparent
            ),
            label = null
        )
    }
}
