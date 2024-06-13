package com.widyawacana.nontonskuy.ui.presentasion.profile

import android.content.Context
import android.graphics.Color
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.widyawacana.nontonskuy.R
import com.widyawacana.nontonskuy.ui.navigation.Screen
import com.widyawacana.nontonskuy.utils.Constant.CLIENT

@Composable
fun ProfileScreen(navController: NavController, context: Context = LocalContext.current) {
    var isSignedOut by remember { mutableStateOf(false) }

    if (isSignedOut) {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Beranda.route) {
                    inclusive = true
                }
            }
        }
    } else {
        ProfileContent(navController = navController, onLogoutClick = {
            val googleLogin =
                GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .requestIdToken(CLIENT)
                    .build()

            @Suppress("DEPRECATION")
            val googleClient = GoogleSignIn.getClient(context, googleLogin)
            googleClient.signOut().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    FirebaseAuth.getInstance().signOut()
                    isSignedOut = true
                } else {
                    Toast.makeText(
                        context,
                        "Logout Gagal",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}

@Composable
fun ProfileContent(navController: NavController, onLogoutClick: () -> Unit) {
    val currentUser = FirebaseAuth.getInstance().currentUser?.email?.substringBefore("@") ?: "N/A"

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 30.dp)
                    .background(
                        color = androidx.compose.ui.graphics.Color.Black,
                        shape = RoundedCornerShape(bottomStart = 360.dp, bottomEnd = 360.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    val borderWidth = 4.dp

                    Image(
                        painter = painterResource(id = R.drawable.img_profile),
                        contentDescription = "Profile Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(132.dp)
                            .border(
                                BorderStroke(borderWidth, androidx.compose.ui.graphics.Color.White),
                                CircleShape
                            )
                            .clip(
                                CircleShape
                            )
                    )
                    Text(
                        text = currentUser,
                        fontSize = 24.sp,
                        color = androidx.compose.ui.graphics.Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }
        }
        item {
            Button(onClick = onLogoutClick, modifier = Modifier.padding(bottom = 24.dp), colors = ButtonDefaults.buttonColors(containerColor = androidx.compose.ui.graphics.Color.Red)) {
                Text(text = "Logout")
            }
        }
//        item {
//            ProfileItemCard(navController = navController, onLogoutClick = onLogoutClick)
//        }
    }
}

@Preview
@Composable
private fun ProfileScreenPrev() {
    ProfileScreen(navController = rememberNavController())
}