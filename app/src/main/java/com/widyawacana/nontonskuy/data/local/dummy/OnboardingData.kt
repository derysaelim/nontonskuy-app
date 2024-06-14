package com.widyawacana.nontonskuy.data.local.dummy

import com.widyawacana.nontonskuy.R
import com.widyawacana.nontonskuy.model.OnBoardingItem

object OnBoardingData {

    val onBoardingItems = listOf(
        OnBoardingItem(
            resId = R.drawable.onboarding_1,
            title = "Selalu Update dengan Film Terkini",
            description = "Jelajahi dan tonton film-film terbaru yang sedang tayang di bioskop favoritmu."
        ),
        OnBoardingItem(
            resId = R.drawable.onboarding_2,
            title = "Temukan Bioskop Terdekat dengan Mudah",
            description = "Cari dan pilih bioskop terdekat dari lokasimu untuk pengalaman menonton yang lebih nyaman."
        ),
        OnBoardingItem(
            resId = R.drawable.onboarding_3,
            title = "Jangan Lewatkan Jadwal Nontonmu",
            description = "Atur pengingat jadwal nonton agar kamu tidak ketinggalan film-film yang ingin kamu tonton."
        ),
    )
}