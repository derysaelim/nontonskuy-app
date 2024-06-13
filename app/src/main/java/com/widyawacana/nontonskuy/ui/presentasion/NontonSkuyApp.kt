package com.widyawacana.nontonskuy.ui.presentasion


import RegisterScreen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.widyawacana.nontonskuy.R
import com.widyawacana.nontonskuy.ui.navigation.NavigationItem
import com.widyawacana.nontonskuy.ui.navigation.Screen
import com.widyawacana.nontonskuy.ui.presentasion.bioskop.BioskopScreen
import com.widyawacana.nontonskuy.ui.presentasion.home.HomeScreen
import com.widyawacana.nontonskuy.ui.presentasion.login.LoginScreen
import com.widyawacana.nontonskuy.ui.presentasion.profile.ProfileScreen
import com.widyawacana.nontonskuy.ui.presentasion.splash.SplashScreen
import com.widyawacana.nontonskuy.utils.shouldShowBottomBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NontonSkuyApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    val navBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStack?.destination?.route
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
            AnimatedVisibility(visible = currentRoute.shouldShowBottomBar()) {
                BottomBar(navController = navController)
            }
        }
    ) { contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Beranda.route) {
                HomeScreen(navController = navController)
            }

            composable(Screen.Bioskop.route) {
                BioskopScreen(navController = navController)
            }

            composable(Screen.Jadwal.route) {
                HomeScreen(navController = navController)
            }

            composable(Screen.Profile.route) {
                ProfileScreen(navController = navController)
            }

            composable(Screen.Splash.route) {
                SplashScreen(navController = navController)
            }

            composable(Screen.Login.route) {
                LoginScreen(navController = navController)
            }

            composable(Screen.Register.route) {
                RegisterScreen(navController = navController)
            }

//            composable(Screen.DetailResep.route + "/{id}",
//                arguments = listOf(navArgument("id") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                DetailResepScreen(
//                    navController = navController,
//                    id = navBackStackEntry.arguments?.getInt("id")
//                )
//            }

        }
    }
}

@Composable
private fun BottomBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_home),
                icon = Icons.Default.Home,
                screen = Screen.Beranda
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_bioskop),
                icon = Icons.Default.LocationOn,
                screen = Screen.Bioskop
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_jadwal),
                icon = Icons.Default.DateRange,
                screen = Screen.Jadwal
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_profile),
                icon = Icons.Default.AccountCircle,
                screen = Screen.Profile
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.route,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) }
            )
        }
    }
}
