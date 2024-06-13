package com.widyawacana.nontonskuy.utils

import com.widyawacana.nontonskuy.ui.navigation.Screen

fun String?.shouldShowBottomBar(): Boolean {
    return this in setOf(
        Screen.Beranda.route,
        Screen.Bioskop.route,
        Screen.Jadwal.route,
        Screen.Profile.route
    )
}