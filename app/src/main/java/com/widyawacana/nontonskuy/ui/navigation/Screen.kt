package com.widyawacana.nontonskuy.ui.navigation
sealed class Screen (val route: String){
    data object Beranda : Screen("beranda")
    data object Bioskop: Screen("bioskop")
    data object Jadwal: Screen("jadwal")
    data object Profile: Screen("profil")
    data object Login: Screen("login")
    data object Register: Screen("register")
    data object Splash: Screen("splash")
}