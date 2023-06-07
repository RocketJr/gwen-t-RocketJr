package cl.uchile.dcc
package gwent

import gwent.States.{GameState, StartGameState}

import gwent.CardType.Cards

class GameController {
  // Estado actual del juego
  var state: GameState = new StartGameState(this)

  def changeState(newState: GameState): Unit = {
    state = newState
  }

  def startGame(): Unit = {
    state.ToStartGame()
  }

  def whoStarts(): Unit = {
    state.ToWhoStarts()
  }

  def playCard(card: Cards): Unit = {
    state.ToPlayCard(card)
  }

  def endTurn(): Unit = {
    state.ToEndTurn()
  }

  def GameOver(): Unit ={
    state.ToGameOver()
  }
}
