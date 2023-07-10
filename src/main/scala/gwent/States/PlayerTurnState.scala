package cl.uchile.dcc
package gwent.States

import gwent.GameController

import gwent.CardType.Cards

class PlayerTurnState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[PlayerTurnState]] to [[NextPlayerTurnState]].
   */
  override def playCard(): Unit = {
    context.state = new NextPlayerTurnState(context)
  }

  override def passTurn(): Unit = {
    context.state = new NextPlayerTurnState(context)
  }
}