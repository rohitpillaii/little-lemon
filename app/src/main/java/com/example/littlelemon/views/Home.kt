package com.example.littlelemon.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
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
import com.example.littlelemon.R


@Composable
fun Home(navController: NavHostController) {
    Column {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement= Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically // Align items vertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                modifier = Modifier .scale(2.5f).weight(1f).padding(start = 20.dp)
            )
            //Create an Image with profile as drawbale and on click go to Profile screen
            Image(painter = painterResource(id = R.drawable.profile), contentDescription = "profile",
                modifier = Modifier
                    .padding(20.dp).size(50.dp)
                    .clickable { navController.navigate(ProfileDestination.route)})

        }

        Text(
            text = "Welcome",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp, // Adjust font size as needed
            color = Color.Black, // Set text color
            modifier = Modifier.padding(20.dp)
        )

    }
}

@Preview(showBackground = false)
@Composable
fun HomePreview() {

}
