package com.example.littlelemon.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.R


@Composable
fun Profile(navController: NavHostController) {

    val sharedPreferences = navController.context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    Column {

        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement= Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically // Align items vertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier
                    .scale(2.5f)
                    .padding(20.dp)
                    .fillMaxWidth()
            )

        }

        Text(
            text = "Profile Information",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp, // Adjust font size as needed
            color = Color.Black, // Set text color
            modifier = Modifier.padding(20.dp)
        )
        ProfileText(text = sharedPreferences.getString("first_name", "").toString(), "First Name")
        ProfileText(text = sharedPreferences.getString("last_name", "").toString(), "Last Name")
        ProfileText(text = sharedPreferences.getString("email", "").toString(),"Email")
        //Text to show all the data from shared preferences
        //TODO:: Logout and When a user clicks on the Log out button, your app should clear all the data from shared preferences and navigate to the Onboarding screen.
        Button(modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(), onClick = {
            sharedPreferences.edit().clear().apply()
            // Navigate to Onboarding screen or perform other actions
            navController.navigate(OnBoardingDestination.route)
        }) {
            Text(text = "Logout")
        }


    }
}

@Composable
fun ProfileText(text: String,type:String) {

    Text(
        text = type,
        fontFamily = FontFamily.SansSerif,
        modifier = Modifier.padding( horizontal = 20.dp) // Add vertical padding between text items
    )

    Surface(
        modifier = Modifier.padding(16.dp)
            .border(width = 1.dp, color = Color.Gray)
            .fillMaxWidth(), // Add border to Surface
        shape = RoundedCornerShape(25.dp) // Optional: Add rounded corners
    ) {
        Text(
            text = text,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.padding(8.dp) // Add padding within the Surface
        )
    }

}

@Preview(showBackground = false)
@Composable
fun ProfilePreview() {

}
