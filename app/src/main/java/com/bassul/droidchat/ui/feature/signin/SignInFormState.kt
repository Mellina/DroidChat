package com.bassul.droidchat.ui.feature.signin

import androidx.annotation.DrawableRes

data class SignInFormState(
    val email: String = "",
    @DrawableRes
    val emailError: Int? = null,
    val password: String = "",
    @DrawableRes
    val passwordError: Int? = null,
    val isLoading: Boolean = false
)
