package com.example.tic_tac_toe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE
    )

    fun onAction(action: UserActions) {
        when (action) {
            is UserActions.BoardTapped -> {
                addValueToBoard(action.cellNo)
            }

            UserActions.PlayAgainButtonClicked -> {
                gameReset()
            }
        }
    }

    private fun gameReset() {
        boardItems.forEach { (i, _) ->
            boardItems[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "Player 'O' turn",
            currentTurn = BoardCellValue.CIRCLE,
            victoryType = VictoryType.NONE,
            hasWon = false
        )
    }

    private fun addValueToBoard(cellNo: Int) {
        if (boardItems[cellNo] != BoardCellValue.NONE)
            return
        if (isBoardFull()) {
            state = state.copy(
                hintText = "Game Drew",
                drawCount = 1 + state.drawCount
            )
            return
        }
        if (checkForVictory(BoardCellValue.CIRCLE) || checkForVictory(BoardCellValue.CROSS)) {
            state = if (state.currentTurn == BoardCellValue.CIRCLE) {
                state.copy(
                    hintText = "Player 'O' won",
                    playerCircleCount = 1 + state.playerCircleCount,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            } else {
                state.copy(
                    hintText = "Player 'X' won",
                    playerCircleCount = 1 + state.playerCrossCount,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            }
        } else if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardItems[cellNo] = BoardCellValue.CIRCLE
            state = state.copy(
                currentTurn = BoardCellValue.CROSS,
                hintText = "Player 'X' turn"
            )
        } else if (state.currentTurn == BoardCellValue.CROSS) {
            boardItems[cellNo] = BoardCellValue.CROSS
            state = state.copy(
                currentTurn = BoardCellValue.CIRCLE,
                hintText = "Player 'O' turn"
            )
        }
    }

    private fun checkForVictory(value: BoardCellValue): Boolean {
        when {
            boardItems[1] == value && boardItems[2] == value && boardItems[3] == value -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL1)
                return true
            }

            boardItems[4] == value && boardItems[5] == value && boardItems[6] == value -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL2)
                return true
            }

            boardItems[7] == value && boardItems[8] == value && boardItems[9] == value -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL3)
                return true
            }

            boardItems[1] == value && boardItems[4] == value && boardItems[7] == value -> {
                state = state.copy(victoryType = VictoryType.VERTICAL1)
                return true
            }

            boardItems[2] == value && boardItems[5] == value && boardItems[8] == value -> {
                state = state.copy(victoryType = VictoryType.VERTICAL2)
                return true
            }

            boardItems[3] == value && boardItems[6] == value && boardItems[9] == value -> {
                state = state.copy(victoryType = VictoryType.VERTICAL3)
                return true
            }

            boardItems[1] == value && boardItems[5] == value && boardItems[9] == value -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL1)
                return true
            }

            boardItems[3] == value && boardItems[5] == value && boardItems[7] == value -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL2)
                return true
            }

            else -> return false
        }
    }

    private fun isBoardFull(): Boolean {
        return !boardItems.containsValue(BoardCellValue.NONE)
    }
}