package com.example.tic_tac_toe

sealed class UserActions {
    data object PlayAgainButtonClicked: UserActions()
    data class BoardTapped(val cellNo: Int) : UserActions()
}