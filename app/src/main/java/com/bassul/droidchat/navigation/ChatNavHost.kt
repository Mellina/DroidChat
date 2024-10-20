package com.bassul.droidchat.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.bassul.droidchat.navigation.extension.slideInTo
import com.bassul.droidchat.navigation.extension.slideOutTo
import com.bassul.droidchat.ui.feature.signin.SignInRoute
import com.bassul.droidchat.ui.feature.signup.SignUpRoute
import com.bassul.droidchat.ui.feature.splash.SplashRoute
import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    object SplashRoute

    @Serializable
    object SignInRoute

    @Serializable
    object SignUpRoute
}


@Composable
fun ChatNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.SplashRoute) {
        composable<Route.SplashRoute> {
            SplashRoute {
                navController.navigate(route = Route.SignInRoute, navOptions = navOptions {
                    popUpTo(Route.SplashRoute) {
                        inclusive = true
                    }
                })
            }
        }
        composable<Route.SignInRoute>(enterTransition = {
            slideInTo(AnimatedContentTransitionScope.SlideDirection.Right)
        }, exitTransition = {
            slideOutTo(AnimatedContentTransitionScope.SlideDirection.Left)
        }

        ) {
            SignInRoute(navigateToSignUp = {
                navController.navigate(Route.SignUpRoute)
            })
        }
        composable<Route.SignUpRoute>(enterTransition = {
            slideInTo(AnimatedContentTransitionScope.SlideDirection.Left)
        }, exitTransition = {
            slideOutTo(AnimatedContentTransitionScope.SlideDirection.Right)
        }) {
            SignUpRoute()
        }
    }
}
