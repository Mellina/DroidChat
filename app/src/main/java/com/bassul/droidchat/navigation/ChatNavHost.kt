package com.bassul.droidchat.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.bassul.droidchat.ui.feature.signin.SignInRoute
import com.bassul.droidchat.ui.feature.splash.SplashRoute
import kotlinx.serialization.Serializable

@Serializable
object SplashRoute

@Serializable
object SignInRoute

@Serializable
object SignUpRoute

@Composable
fun ChatNavHost() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SplashRoute) {
        composable<SplashRoute> {
            SplashRoute {
                navController.navigate(
                    route = SignInRoute,
                    navOptions = navOptions {
                        popUpTo(SplashRoute) {
                            inclusive = true
                        }
                    })
            }
        }
        composable<SignInRoute> {
            SignInRoute()
        }
        composable<SignUpRoute> {

        }
    }
}
