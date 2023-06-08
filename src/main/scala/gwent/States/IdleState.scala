package cl.uchile.dcc
package gwent.States

import gwent.GameController

class IdleState(context: GameController) extends GameState(context) {
  /** Transition the game state from [[IdleState]] to [[PlayerTurnState]].
   */
  override def ToPlayerTurn(): Unit = {
    context.state = new PlayerTurnState(context)
  }

  /** Transition the game state from [[IdleState]] to [[EndTurnState]].
   */
  override def ToEndTurn(): Unit = {
    context.state = new EndTurnState(context)
  }
}