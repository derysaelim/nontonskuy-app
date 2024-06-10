//package com.widyawacana.nontonskuy.ui.presentasion
//
//
//import android.os.Build
//import androidx.annotation.RequiresApi
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.layout.padding
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.AccountCircle
////import androidx.compose.material.icons.filled.Article
////import androidx.compose.material.icons.filled.CalendarMonth
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.stringResource
////import androidx.navigation.NavGraph.Companion.findStartDestination
////import androidx.navigation.NavHostController
////import androidx.navigation.NavType
////import androidx.navigation.compose.NavHost
////import androidx.navigation.compose.composable
////import androidx.navigation.compose.currentBackStackEntryAsState
////import androidx.navigation.compose.rememberNavController
////import androidx.navigation.navArgument
////import com.example.stuncare.presentation.LoginScreen
////import com.widyawacana.stuncare.MainActivity
////import com.widyawacana.stuncare.R
////import com.widyawacana.stuncare.ui.navigation.NavigationItem
////import com.widyawacana.stuncare.ui.navigation.Screen
////import com.widyawacana.stuncare.ui.presentation.artikel.PageArtikelAwal
////import com.widyawacana.stuncare.ui.presentation.artikel.detailartikel
////import com.widyawacana.stuncare.ui.presentation.beranda.HomeScreen
////import com.widyawacana.stuncare.ui.presentation.chatbot.ChatbotScreen
////import com.widyawacana.stuncare.ui.presentation.gizianak.StatusGiziAnakScreen
////import com.widyawacana.stuncare.ui.presentation.gizianak.giziawalpage
////import com.widyawacana.stuncare.ui.presentation.kehamilan.PerkembanganKehamilanScreen
////import com.widyawacana.stuncare.ui.presentation.kehamilan.StatusPerkembanganKehamilanScreen
////import com.widyawacana.stuncare.ui.presentation.profile.AboutScreen
////import com.widyawacana.stuncare.ui.presentation.profile.ContactUsScreen
////import com.widyawacana.stuncare.ui.presentation.profile.EditProfileScreen
////import com.widyawacana.stuncare.ui.presentation.profile.ProfileScreen
////import com.widyawacana.stuncare.ui.presentation.profile.TermConditionScreen
////import com.widyawacana.stuncare.ui.presentation.register.PageRegister
////import com.widyawacana.stuncare.ui.presentation.resep.DetailResepScreen
////import com.widyawacana.stuncare.ui.presentation.resep.MenuSarapanScreen
////import com.widyawacana.stuncare.ui.presentation.resep.ResepScreen
////import com.widyawacana.stuncare.ui.presentation.webinar.DetailWebinarScreen
////import com.widyawacana.stuncare.ui.presentation.webinar.WebinarScreen
////import com.widyawacana.stuncare.utils.shouldShowBottomBar
////import pagegzianak
//
//@RequiresApi(Build.VERSION_CODES.O)
//@Composable
//fun StuncareApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
//    val navBackStack by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStack?.destination?.route
//    val context = LocalContext.current
//
//    Scaffold(
//        bottomBar = {
//            AnimatedVisibility(visible = currentRoute.shouldShowBottomBar()) {
//                BottomBar(navController = navController)
//            }
//        }
//    ) { contentPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = Screen.Login.route,
//            modifier = modifier.padding(contentPadding)
//        ) {
//            composable(Screen.Home.route) {
//                HomeScreen(navController = navController)
//            }
//
//            composable(Screen.Webinar.route) {
//                WebinarScreen(navController = navController)
//            }
//
//            composable(Screen.Artikel.route) {
//                PageArtikelAwal(navController = navController)
//            }
//
//            composable(Screen.Profil.route) {
//                ProfileScreen(navController = navController)
//            }
//
//            composable(Screen.EditProfil.route) {
//                EditProfileScreen(navController = navController)
//            }
//
//            composable(Screen.ContactUs.route) {
//                ContactUsScreen(navController = navController)
//            }
//
//            composable(Screen.TermCondition.route) {
//                TermConditionScreen(navController = navController)
//            }
//
//            composable(Screen.About.route) {
//                AboutScreen(navController = navController)
//            }
//
//            composable(Screen.Resep.route) {
//                ResepScreen(navController = navController)
//            }
//
//            composable(Screen.MenuSarapan.route) {
//                MenuSarapanScreen(navController = navController)
//            }
//
//            composable(Screen.DetailResep.route + "/{id}",
//                arguments = listOf(navArgument("id") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                DetailResepScreen(
//                    navController = navController,
//                    id = navBackStackEntry.arguments?.getInt("id")
//                )
//            }
//
//            composable(Screen.DetailWebinar.route + "/{id}",
//                arguments = listOf(navArgument("id") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                DetailWebinarScreen(
//                    navController = navController,
//                    id = navBackStackEntry.arguments?.getInt("id")
//                )
//            }
//
//            composable(Screen.PerkembanganKehamilan.route) {
//                PerkembanganKehamilanScreen(navController = navController)
//            }
//
//            composable(Screen.StatusPerkembanganKehamilan.route) {
//                StatusPerkembanganKehamilanScreen(navController = navController)
//            }
//
//            composable(Screen.GiziAnakAwal.route) {
//                giziawalpage(navController = navController)
//            }
//
//            composable(Screen.PageGiziAnak.route) {
//                pagegzianak(navController = navController)
//            }
//
//            composable(Screen.StatusGiziAnak.route) {
//                StatusGiziAnakScreen(navController = navController)
//            }
//
//            composable(Screen.DetailArtikel.route + "/{id}",
//                arguments = listOf(navArgument("id") { type = NavType.IntType })
//            ) { navBackStackEntry ->
//                detailartikel(
//                    navController = navController,
//                    id = navBackStackEntry.arguments?.getInt("id")
//                )
//            }
//
//            composable(Screen.Login.route) {
//                LoginScreen(navController = navController)
//            }
//
//            composable(Screen.Register.route) {
//                PageRegister(navController = navController)
//            }
//
//            composable(Screen.Chatbot.route) {
//                ChatbotScreen()
//            }
//        }
//    }
//}
//
//@Composable
//private fun BottomBar(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    NavigationBar(
//        modifier = modifier
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//
//        val navigationItems = listOf(
//            NavigationItem(
//                title = stringResource(id = R.string.menu_home),
//                icon = Icons.Default.Home,
//                screen = Screen.Home
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_webinar),
//                icon = Icons.Default.CalendarMonth,
//                screen = Screen.Webinar
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_artikel),
//                icon = Icons.Default.Article,
//                screen = Screen.Artikel
//            ),
//            NavigationItem(
//                title = stringResource(id = R.string.menu_profil),
//                icon = Icons.Default.AccountCircle,
//                screen = Screen.Profil
//            )
//        )
//        navigationItems.map { item ->
//            NavigationBarItem(
//                selected = currentRoute == item.screen.route,
//                onClick = {
//                    navController.navigate(item.screen.route) {
//                        popUpTo(navController.graph.findStartDestination().id) {
//                            saveState = true
//                        }
//                        restoreState = true
//                        launchSingleTop = true
//                    }
//                },
//                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
//                label = { Text(text = item.title) }
//            )
//        }
//    }
//}