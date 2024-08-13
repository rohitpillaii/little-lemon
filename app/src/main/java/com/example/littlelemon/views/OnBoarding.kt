package com.example.littlelemon.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R


@Composable
fun OnBoarding(navController: NavHostController){

    //TODO:: create a var first with remember Mutable state
    var first by remember { mutableStateOf("") }
    var last by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }


    Column {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "logo",
        modifier = Modifier.padding(50.dp)
    )
    TextField(modifier = Modifier.align(Alignment.CenterHorizontally)
        .fillMaxWidth()
        .padding(20.dp),
        value = first ,
        onValueChange = {first = it})
    TextField(modifier = Modifier.align(Alignment.CenterHorizontally)
        .fillMaxWidth()
        .padding(20.dp),
            value = last ,
        onValueChange = {last = it})
    TextField(modifier = Modifier.align(Alignment.CenterHorizontally)
        .fillMaxWidth()
        .padding(20.dp),
        value = email ,
        onValueChange = {email = it})

        Button(modifier = Modifier.padding(20.dp).fillMaxWidth(), onClick = {
            if (first.isBlank() || last.isBlank() || email.isBlank()) {
                message = "Registration unsuccessful. Please enter all data."
                Toast.makeText(navController.context, message, Toast.LENGTH_SHORT).show()
            } else {
                saveUserData(context = navController.context , first, last, email)
                message = "Registration successful!"
                Toast.makeText(navController.context, message, Toast.LENGTH_SHORT).show()
                navController.navigate(HomeDestination.route)
            }
        }) {
            Text(text = "Register")
        }

    }
}


private fun saveUserData(context: Context, firstName: String, lastName: String, email: String) {
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    with(sharedPreferences.edit()) {
        putString("first_name", firstName)
        putString("last_name", lastName)
        putString("email", email)
        putBoolean("onboarded", true) // Mark user as onboarded
        apply()
    }
}

@Preview(showBackground = false)
@Composable
fun OnBoardingPreview() {
//    OnBoarding(context = conte)
}
