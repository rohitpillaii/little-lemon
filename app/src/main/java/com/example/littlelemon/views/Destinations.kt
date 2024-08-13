package com.example.littlelemon.views

interface Destination {
    val route: String
}

object HomeDestination : Destination {
    override val route = "home"
}object ProfileDestination : Destination {
    override val route = "profile"
}
object OnBoardingDestination : Destination {
    override val route = "onboarding"
}