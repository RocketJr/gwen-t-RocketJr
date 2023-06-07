package cl.uchile.dcc
package gwent.States

import gwent.CardType.Cards

import gwent.GameController

class GameState protected(val context: GameController) {
  context.state = this

  def ToStartGame(): Unit = {
    transitionError("StartGameState")
  }

  def ToWhoStarts(): Unit = {
    transitionError("WhoStartsFirstState")
  }

  def ToIdleState(): Unit = {
    transitionError("IdleState")
  }

  def ToPlayerTurn(): Unit = {
    transitionError("PlayerTurnState")
  }

  def ToNextPlayerTurn(): Unit = {
    transitionError("NextPlayerTurnState")
  }

  def ToEndTurn(): Unit = {
    transitionError("EndTurnState")
  }

  def ToBeginTurn(): Unit = {
    transitionError("BeginTurnState")
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
