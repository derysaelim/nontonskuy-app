package com.widyawacana.nontonskuy.ui.presentasion.maps.component

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.widyawacana.nontonskuy.R
import com.widyawacana.nontonskuy.model.Bioskop

@Composable
fun CardBioskopItem(
    modifier: Modifier = Modifier,
    listBioskop: Bioskop,
    onItemClicked: (Int) -> Unit
) {
    Card(
        onClick = { onItemClicked(listBioskop.id) },
        modifier = modifier
            .fillMaxWidth()
            .height(120.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = listBioskop.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = modifier.padding(
                        start = 10.dp,
                        top = 0.dp,
                        end = 10.dp,
                        bottom = 0.dp
                    )
                )
                Row(
                    modifier = modifier.padding(
                        start = 10.dp,
                        top = 0.dp,
                        end = 10.dp,
                        bottom = 0.dp
                    ), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Icon Rating",
                        tint = Color(0xFFFBBC04),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = listBioskop.rating.toString() + "/5",
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = listBioskop.location,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    modifier = modifier
                        .padding(
                            start = 10.dp,
                            top = 0.dp,
                            end = 10.dp,
                            bottom = 0.dp
                        )
                        .width(180.dp)
                )
            }
            Image(
                painter = painterResource(id = listBioskop.photo),
                contentDescription = "Image Game",
                modifier = modifier
                    .height(80.dp)
                    .width(170.dp)
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(percent = 10)),
                contentScale = ContentScale.Crop
            )
        }
    }
}