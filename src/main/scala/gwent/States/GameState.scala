package cl.uchile.dcc
package gwent.States

import gwent.CardType.Cards

import gwent.GameController

class GameState protected(val context: GameController) {
  context.state = this

  def ToIdleState(): Unit = {
    transitionError("IdleState")
  }

  def ToPlayerTurn(): Unit = {
    transitionError("PlayerTurnState")
  }

  def playCard(): Unit = {
    transitionError("PlayerTurnState")
  }

  def passTurn(): Unit = {
    transitionError("PlayerTurnState")
  }

  //def ToNextPlayerTurn(): Unit = {
  //  transitionError("NextPlayerTurnState")
  //}

  def ToEndTurn(): Unit = {
    transitionError("EndTurnState")
  }

  def ToStartTurn(): Unit = {
    transitionError("StartTurnState")
  }

  def ToGameOver(): Unit = {
    transitionError("GameOverState")
  }

  private def transitionError(targetState: String): Unit = {
    throw new InvalidTransitionException(
      s"Cannot transition from ${getClass.getSimpleName} to $targetState"
    )
  }
}